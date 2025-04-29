package org.example.trigger.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.award.event.SendAwardMessageEvent;
import org.example.domain.award.model.entity.DistributeAwardEntity;
import org.example.domain.award.service.AwardService;
import org.example.domain.award.service.IAwardService;
import org.example.types.event.BaseEvent;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: 机智的赛尔
 * @Description： 用户奖品记录消息消费者
 * @DateTime： 2025/4/12 12:51
 **/

@Slf4j
@Component
public class SendAwardCustomer {

    @Value("${spring.rabbitmq.topic.send_award}")
    private String topic;

    @Resource
    private IAwardService awardService;

    @RabbitListener(queuesToDeclare = @Queue(value = "${spring.rabbitmq.topic.send_award}"))
    public void listener(String message) {
        try {
            log.info("监听用户奖品发送消息 topic: {} message: {}", topic, message);
            BaseEvent.EventMessage<SendAwardMessageEvent.SendAwardMessage> eventMessage = JSON.parseObject(message, new TypeReference<BaseEvent.EventMessage<SendAwardMessageEvent.SendAwardMessage>>() {
            }.getType());
            SendAwardMessageEvent.SendAwardMessage sendAwardMessage = eventMessage.getData();

            // 发放奖品
            DistributeAwardEntity distributeAwardEntity = new DistributeAwardEntity();
            distributeAwardEntity.setUserId(sendAwardMessage.getUserId());
            distributeAwardEntity.setOrderId(sendAwardMessage.getOrderId());
            distributeAwardEntity.setAwardId(sendAwardMessage.getAwardId());
            distributeAwardEntity.setAwardConfig(sendAwardMessage.getAwardConfig());
            awardService.distributeAward(distributeAwardEntity);
            log.info("监听用户奖品发送消息成功 topic: {} message: {}", topic, message);
        } catch (Exception e) {
            log.error("监听用户奖品发送消息，消费失败 topic: {} message: {}", topic, message);
            throw e;
        }
    }

}

