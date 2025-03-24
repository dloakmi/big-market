package org.example.domain.activity.service;

import org.example.domain.activity.model.entity.ActivityOrderEntity;
import org.example.domain.activity.model.entity.ActivityShopCartEntity;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖活动订单接口
 * @DateTime： 2025/3/24 10:44
 **/

public interface IRaffleOrder {

    /**
     * @description: 以sku创建抽奖活动订单，获得参与抽奖资格（可消耗次数）
     * @author: 超级机智的赛尔
     * @date: 2025/3/24 11:08
     * @param activityShopCartEntity 活动sku实体，通过sku领取活动
     * @Return: 活动参与记录实体
     **/
    ActivityOrderEntity createRaffleActivityOrder(ActivityShopCartEntity activityShopCartEntity);

}
