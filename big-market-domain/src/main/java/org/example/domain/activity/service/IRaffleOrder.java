package org.example.domain.activity.service;

import org.example.domain.activity.model.entity.ActivityOrderEntity;
import org.example.domain.activity.model.entity.ActivityShopCartEntity;
import org.example.domain.activity.model.entity.SkuRechargeEntity;

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

    /**
     * @description: 创建sku账户充值订单，给用户增加抽奖次数
     * <p>
     * 1.在【打卡、签到、分享、对话、积分兑换】等行为动作下，创建出活动订单，给用户的活动账号【日、月】充值可用的抽奖次数
     * <p>
     * 2.对于用户可获得的抽奖次数，比如首次进来就有一次，则是依赖于运营配置的动作，在前端页面上。用户点击后，可获得一次抽奖次数
     *
     * @author: 超级机智的赛尔
     * @date: 2025/3/24 14:32
     * @param skuRechargeEntity 活动商品充值实体对象
     * @Return: 活动ID
     **/
    String createSkuRechargeOrder(SkuRechargeEntity skuRechargeEntity);


}
