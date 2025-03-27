package org.example.trigger.listener;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.activity.service.ISkuStock;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: 机智的赛尔
 * @Description： 活动sku库存耗尽
 * @DateTime： 2025/3/27 17:44
 **/

@Slf4j
@Component
public class ActivitySkuStockZeroCustomer {

    @Value("${spring.rabbitmq.topic.activity_sku_stock_zero}")
    private String topic;

    @Resource
    private ISkuStock skuStock;

    @RabbitListener(queuesToDeclare = @Queue(value = "activity_sku_stock_zero"))
    public void listener(String message) {
        try{
            log.info("监听活动sku库存消耗为0消息 topic:{} message:{}", "activity_sku_stock_zero", message);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
