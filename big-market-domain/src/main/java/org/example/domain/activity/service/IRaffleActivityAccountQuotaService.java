package org.example.domain.activity.service;

import org.example.domain.activity.model.entity.ActivityAccountEntity;
import org.example.domain.activity.model.entity.ActivityOrderEntity;
import org.example.domain.activity.model.entity.ActivityShopCartEntity;
import org.example.domain.activity.model.entity.SkuRechargeEntity;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖活动订单接口
 * @DateTime： 2025/3/24 10:44
 **/

public interface IRaffleActivityAccountQuotaService {


    /**
     * <p> 1.在【打卡、签到、分享、对话、积分兑换】等行为动作（活动）下，创建出活动订单，给用户的活动账号【日、月】充值可用的抽奖次数
     * （因为上面的行为触发活动订单肯定不能无限次数，所以可以把它们算作一种sku）
     * <p> 2.对于用户可获得的抽奖次数，比如首次进来就有一次，则是依赖于运营配置的动作，在前端页面上。用户点击后，可获得一次抽奖次数
     *
     *
     * @description: 1. 创建活动sku账户充值订单 <p>2. 给用户(总，月，日)账户增加抽奖次数 <p>3. 发送充值成功的MQ消息
     * @author: 超级机智的赛尔
     * @date: 2025/3/24 14:32
     * @param skuRechargeEntity 活动商品sku充值实体对象
     * @Return: 活动ID
     **/
    String createOrder(SkuRechargeEntity skuRechargeEntity);

    /**
     * @description: 查询活动的某sku 在某天的剩余量
     * @author: 超级机智的赛尔
     * @date: 2025/4/17 10:57
     * @param activityId 活动ID
     * @param userId 用户ID
     * @Return: 剩余量
     **/
    Integer queryRaffleActivityAccountDayPartakeCount(Long activityId, String userId);

    ActivityAccountEntity queryActivityAccountEntity(String userId, Long activityId);


}
