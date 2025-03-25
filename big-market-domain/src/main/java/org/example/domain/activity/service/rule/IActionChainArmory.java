package org.example.domain.activity.service.rule;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖动作责任链装配
 * @DateTime： 2025/3/25 14:41
 **/

public interface IActionChainArmory {

    IActionChain next();

    IActionChain appendNext(IActionChain next);

}
