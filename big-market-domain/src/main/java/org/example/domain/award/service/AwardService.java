package org.example.domain.award.service;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.award.event.SendAwardMessageEvent;
import org.example.domain.award.model.aggregate.UserAwardRecordAggregate;
import org.example.domain.award.model.entity.DistributeAwardEntity;
import org.example.domain.award.model.entity.TaskEntity;
import org.example.domain.award.model.entity.UserAwardRecordEntity;
import org.example.domain.award.model.valobj.TaskStateVO;
import org.example.domain.award.repository.IAwardRepository;
import org.example.domain.award.service.distribute.IDistributeAward;
import org.example.types.event.BaseEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author: 机智的赛尔
 * @Description： 奖品服务
 * @DateTime： 2025/4/9 16:54
 **/

@Slf4j
@Service
public class AwardService implements IAwardService {


    private final IAwardRepository awardRepository;

    private final SendAwardMessageEvent sendAwardMessageEvent;

    private final Map<String, IDistributeAward> distributeAwardMap;

    public AwardService(IAwardRepository awardRepository, SendAwardMessageEvent sendAwardMessageEvent, Map<String, IDistributeAward> distributeAwardMap) {
        this.awardRepository = awardRepository;
        this.sendAwardMessageEvent = sendAwardMessageEvent;
        this.distributeAwardMap = distributeAwardMap;
    }


    @Override
    public void saveUserAwardRecord(UserAwardRecordEntity userAwardRecordEntity) {

        // 构建信息对象
        SendAwardMessageEvent.SendAwardMessage sendAwardMessage = new SendAwardMessageEvent.SendAwardMessage();
        sendAwardMessage.setAwardId(userAwardRecordEntity.getAwardId());
        sendAwardMessage.setUserId(userAwardRecordEntity.getUserId());
        sendAwardMessage.setAwardTitle(userAwardRecordEntity.getAwardTitle());
        sendAwardMessage.setOrderId(userAwardRecordEntity.getOrderId());
        sendAwardMessage.setAwardConfig(userAwardRecordEntity.getAwardConfig());

        BaseEvent.EventMessage<SendAwardMessageEvent.SendAwardMessage> sendAwardMessageEventMessage = sendAwardMessageEvent.buildEventMessage(sendAwardMessage);

        // 构建任务对象
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setUserId(userAwardRecordEntity.getUserId());
        taskEntity.setTopic(sendAwardMessageEvent.topic());
        taskEntity.setMessageId(sendAwardMessageEventMessage.getId());
        taskEntity.setMessage(sendAwardMessageEventMessage);
        taskEntity.setState(TaskStateVO.create);

        // 构建聚合对象
        UserAwardRecordAggregate userAwardRecordAggregate = UserAwardRecordAggregate.builder()
                .taskEntity(taskEntity)
                .userAwardRecordEntity(userAwardRecordEntity)
                .build();

        // 存储聚合对象 - 一个事务下，用户的中奖记录
        awardRepository.saveUserAwardRecord(userAwardRecordAggregate);

    }

    @Override
    public void distributeAward(DistributeAwardEntity distributeAwardEntity) {
        // 奖品Key
        String awardKey = awardRepository.queryAwardKey(distributeAwardEntity.getAwardId());
        if(null == awardKey){
            log.error("分发奖品，奖品ID不存在 awardKey:{}",distributeAwardEntity.getAwardId());
            return;
        }

        IDistributeAward distributeAward = distributeAwardMap.get(awardKey);
        if(null == distributeAward){
            log.error("分发奖品，对应的服务不存在 awardKey:{}",awardKey);
            // todo 后续完成其他服务
            return;
        }

        // 发放奖品
        distributeAward.giveOutPrizes(distributeAwardEntity);

    }
}
