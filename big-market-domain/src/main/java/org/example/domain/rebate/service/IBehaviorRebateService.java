package org.example.domain.rebate.service;

import org.example.domain.rebate.model.entity.BehaviorEntity;

import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： 行为返利服务接口
 * @DateTime： 2025/4/17 13:32
 **/

public interface IBehaviorRebateService {

    /**
     * @description: 根据 用户行为 -> 多种返利配置 -> 产生多种订单（1.返利订单 2.任务订单（发送MQ））
     * @author: 超级机智的赛尔
     * @date: 2025/4/23 10:50
     * @param: behaviorEntity
     * @Return: 订单IDs
     **/
    List<String> createOrder(BehaviorEntity behaviorEntity);

}
