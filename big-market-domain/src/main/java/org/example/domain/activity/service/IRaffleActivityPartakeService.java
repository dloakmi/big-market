package org.example.domain.activity.service;

import org.example.domain.activity.model.entity.ActivityAccountEntity;
import org.example.domain.activity.model.entity.PartakeRaffleActivityEntity;
import org.example.domain.activity.model.entity.UserRaffleOrderEntity;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖活动参与服务
 * @DateTime： 2025/3/31 10:51
 **/

public interface IRaffleActivityPartakeService {


    /**
     * @description: 创建抽奖单；用户参与抽奖活动，扣减活动账户库存，产生抽奖单。如存在未被使用的抽奖单则直接返回已存在的抽奖单。
     * @author: 超级机智的赛尔
     * @date: 2025/4/14 12:31
     * @param userId 用户ID
     * @param activityId 活动ID
     * @Return: 用户抽奖订单实体对象
     **/
    UserRaffleOrderEntity createOrder(String userId, Long activityId);
    /**
     * @description: 创建抽奖单；用户参与抽奖活动，扣减活动账户库存，产生抽奖单。如存在未被使用的抽奖单则直接返回已存在的抽奖单。
     * @author: 超级机智的赛尔
     * @date: 2025/3/31 12:29
     * @param partakeRaffleActivityEntity 参与抽奖活动实体对象
     * @Return: 用户抽奖订单实体对象
     **/
    UserRaffleOrderEntity createOrder(PartakeRaffleActivityEntity partakeRaffleActivityEntity);


}
