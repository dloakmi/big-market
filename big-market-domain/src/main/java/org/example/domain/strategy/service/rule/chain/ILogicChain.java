package org.example.domain.strategy.service.rule.chain;

import org.example.domain.strategy.service.rule.chain.factory.DefaultChainFactory;

/**
 * @Author: 机智的赛尔
 * @Description： 责任链接口
 * @DateTime： 2025/2/26 19:40
 **/

public interface ILogicChain extends ILogicChainArmory{


    /**
     * @description: 执行接口
     * @author: 超级机智的赛尔
     * @date: 2025/2/26 19:41
     * @param: userId 用户ID
     * @param: strategyId 策略ID
     * @Return: 抽奖前置返回信息
     **/
    DefaultChainFactory.StrategyAwardVO logic (String userId, Long strategyId);


}
