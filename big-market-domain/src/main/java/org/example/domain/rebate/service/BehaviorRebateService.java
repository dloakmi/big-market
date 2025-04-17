package org.example.domain.rebate.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.domain.award.model.valobj.TaskStateVO;
import org.example.domain.rebate.event.SendRebateMessageEvent;
import org.example.domain.rebate.model.aggregate.BehaviorRebateAggregate;
import org.example.domain.rebate.model.entity.BehaviorEntity;
import org.example.domain.rebate.model.entity.BehaviorRebateOrderEntity;
import org.example.domain.rebate.model.entity.TaskEntity;
import org.example.domain.rebate.model.valobj.DailyBehaviorRebateVO;
import org.example.domain.rebate.repository.IBehaviorRebateRepository;
import org.example.types.common.Constants;
import org.example.types.event.BaseEvent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： 行为返利服务实现
 * @DateTime： 2025/4/17 13:40
 **/

@Service
public class BehaviorRebateService implements IBehaviorRebateService {

    @Resource
    private IBehaviorRebateRepository behaviorRebateRepository;

    @Resource
    private SendRebateMessageEvent sendRebateMessageEvent;

    @Override
    public List<String> createOrder(BehaviorEntity behaviorEntity) {
        // 查询返利配置
        List<DailyBehaviorRebateVO> dailyBehaviorRebateVOS = behaviorRebateRepository.queryDailyBehaviorRebateConfig(behaviorEntity.getBehaviorType());
        if (dailyBehaviorRebateVOS == null || dailyBehaviorRebateVOS.isEmpty()) return new ArrayList<String>();

        // 构建聚合对象
        List<String> orderIds = new ArrayList<>();
        List<BehaviorRebateAggregate> behaviorRebateAggregates = new ArrayList<>();

        for(DailyBehaviorRebateVO dailyBehaviorRebateVO:dailyBehaviorRebateVOS){
            // 拼装业务ID; 用户ID_返利类型_外部透彻业务ID
            String bizId = behaviorEntity.getUserId() + Constants.UNDERLINE + dailyBehaviorRebateVO.getBehaviorType() + Constants.UNDERLINE + behaviorEntity.getOutBusinessNo();

            BehaviorRebateOrderEntity behaviorRebateOrderEntity = BehaviorRebateOrderEntity.builder()
                    .userId(behaviorEntity.getUserId())
                    .orderId(RandomStringUtils.randomNumeric(12))
                    .behaviorType(dailyBehaviorRebateVO.getBehaviorType())
                    .rebateDesc(dailyBehaviorRebateVO.getRebateDesc())
                    .rebateConfig(dailyBehaviorRebateVO.getRebateConfig())
                    .rebateType(dailyBehaviorRebateVO.getRebateType())
                    .bizId(bizId)
                    .build();

            orderIds.add(behaviorRebateOrderEntity.getOrderId());

            // MQ 消息对象
            SendRebateMessageEvent.RebateMessage rebateMessage = SendRebateMessageEvent.RebateMessage.builder()
                    .userId(behaviorEntity.getUserId())
                    .rebateType(dailyBehaviorRebateVO.getRebateType())
                    .rebateConfig(dailyBehaviorRebateVO.getRebateConfig())
                    .bizId(bizId)
                    .build();


            // 构建事件消息
            BaseEvent.EventMessage<SendRebateMessageEvent.RebateMessage> rebateMessageEventMessage = sendRebateMessageEvent.buildEventMessage(rebateMessage);

            // 组装任务对象
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setUserId(behaviorEntity.getUserId());
            taskEntity.setTopic(sendRebateMessageEvent.topic());
            taskEntity.setMessageId(rebateMessageEventMessage.getId());
            taskEntity.setMessage(rebateMessageEventMessage);
            taskEntity.setState(TaskStateVO.create);

            BehaviorRebateAggregate behaviorRebateAggregate = BehaviorRebateAggregate.builder()
                    .userId(behaviorEntity.getUserId())
                    .behaviorRebateOrder(behaviorRebateOrderEntity)
                    .taskEntity(taskEntity)
                    .build();

            behaviorRebateAggregates.add(behaviorRebateAggregate);
        }

        // 存储聚合对象数据
        behaviorRebateRepository.saveUserRebateRecord(behaviorEntity.getUserId(),behaviorRebateAggregates);

        // 返回订单ID集合
        return orderIds;
    }
}
