package org.example.domain.strategy.service.rule.tree.factory.engine;

import org.example.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

import java.util.Date;

/**
 * @Author: 机智的赛尔
 * @Description： 规则树组合接口
 * @DateTime： 2025/3/3 21:02
 **/

public interface IDecisionTreeEngine {

    /**
     * @description: 策略树执行
     * @author: 超级机智的赛尔
     * @date: 2025/3/15 13:45
     * @param userId 用户ID
     * @param strategyId 策略ID
     * @param awardId 奖品ID
     * @Return: 策略树流转过程中结果
     **/
    DefaultTreeFactory.StrategyAwardVO process(String userId, Long strategyId, Integer awardId , Date endDateTime);

}

