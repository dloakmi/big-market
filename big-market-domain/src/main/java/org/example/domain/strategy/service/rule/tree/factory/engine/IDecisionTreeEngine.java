package org.example.domain.strategy.service.rule.tree.factory.engine;

import org.example.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @Author: 机智的赛尔
 * @Description： 规则树组合接口
 * @DateTime： 2025/3/3 21:02
 **/

public interface IDecisionTreeEngine {

    DefaultTreeFactory.StrategyAwardData process(String userId, Long strategyId, Integer awardId);

}

