package org.example.domain.strategy.service;

import org.example.domain.strategy.model.entity.RaffleAwardEntity;
import org.example.domain.strategy.model.entity.RaffleFactorEntity;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖策略接口
 * @DateTime： 2025/2/25 9:30
 **/

public interface IRaffleStrategy {

    /**
     * @description: 执行抽奖 （哦耶！！！）
     * @author: 超级机智的赛尔
     * @date: 2025/2/25 19:54
     * @param: raffleFactorEntity 根据抽奖必要的因子 （用户，策略ID）
     * @Return: 获得一个抽奖结果
     **/
    RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity);


}
