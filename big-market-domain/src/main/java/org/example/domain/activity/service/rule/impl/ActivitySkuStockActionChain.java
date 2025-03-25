package org.example.domain.activity.service.rule.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.activity.model.entity.ActivityCountEntity;
import org.example.domain.activity.model.entity.ActivityEntity;
import org.example.domain.activity.model.entity.ActivitySkuEntity;
import org.example.domain.activity.service.rule.AbstractActionChain;
import org.springframework.stereotype.Component;

/**
 * @Author: 机智的赛尔
 * @Description： 商店库存规则节点
 * @DateTime： 2025/3/25 14:51
 **/

@Slf4j
@Component("activity_sku_stock_action")
public class ActivitySkuStockActionChain extends AbstractActionChain {

    @Override
    public boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity) {
        log.info("活动责任链-商店库存处理【校验&扣减】开始");



        return false;
    }
}
