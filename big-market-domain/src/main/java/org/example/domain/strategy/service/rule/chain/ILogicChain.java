package org.example.domain.strategy.service.rule.chain;

/**
 * @Author: 机智的赛尔
 * @Description： 责任链接口
 * @DateTime： 2025/2/26 19:40
 **/

public interface ILogicChain {


    /**
     * @description: 执行接口
     * @author: 超级机智的赛尔
     * @date: 2025/2/26 19:41
     * @param: userId 用户ID
     * @param: strategyId 策略ID
     * @Return: 奖品ID
     **/
    Integer logic (String userId, Long strategyId);

    ILogicChain appendNext(ILogicChain next);

    ILogicChain next();
}
