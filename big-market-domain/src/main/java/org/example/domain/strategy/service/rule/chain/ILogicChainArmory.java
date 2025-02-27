package org.example.domain.strategy.service.rule.chain;

/**
 * @Author: 机智的赛尔
 * @Description： 责任链装配接口
 * @DateTime： 2025/2/27 16:57
 **/

public interface ILogicChainArmory {

    ILogicChain appendNext(ILogicChain next);

    ILogicChain next();
}
