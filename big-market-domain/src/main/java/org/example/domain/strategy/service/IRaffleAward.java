package org.example.domain.strategy.service;

import org.example.domain.strategy.model.entity.StrategyAwardEntity;

import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： 策略奖品接口
 * @DateTime： 2025/3/13 14:59
 **/

public interface IRaffleAward {


    /**
     * @description: 根据策略ID查询抽奖奖品列表配置
     * @author: 超级机智的赛尔
     * @date: 2025/3/13 15:08
     * @param strategyId 策略ID
     * @Return: 奖品列表
     **/
    List<StrategyAwardEntity> queryRaffleStrategyAwardList(long strategyId);


}
