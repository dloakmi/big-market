package org.example.domain.strategy.service.rule.tree;

import org.example.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @Author: 机智的赛尔
 * @Description： 规则树接口
 * @DateTime： 2025/3/3 20:58
 **/

public interface ILogicTreeNode {

    DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId);

}

