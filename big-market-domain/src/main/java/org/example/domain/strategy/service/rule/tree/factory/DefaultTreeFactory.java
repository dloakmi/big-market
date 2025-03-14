package org.example.domain.strategy.service.rule.tree.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import org.example.domain.strategy.model.valobj.RuleTreeVO;
import org.example.domain.strategy.service.rule.tree.ILogicTreeNode;
import org.example.domain.strategy.service.rule.tree.factory.engine.IDecisionTreeEngine;
import org.example.domain.strategy.service.rule.tree.factory.engine.impl.DecisionTreeEngine;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: 机智的赛尔
 * @Description： 规则树工厂
 * @DateTime： 2025/3/3 21:00
 **/

@Service
public class DefaultTreeFactory {

    private final Map<String, ILogicTreeNode> logicTreeNodeGroup;

    public DefaultTreeFactory(Map<String, ILogicTreeNode> logicTreeNodeGroup) {
        this.logicTreeNodeGroup = logicTreeNodeGroup;
    }

    public IDecisionTreeEngine openLogicTree(RuleTreeVO ruleTreeVO) {
        return new DecisionTreeEngine(logicTreeNodeGroup, ruleTreeVO);
    }


    /**
     * @Author: 机智的赛尔
     * @Description： 决策树经过一次递归后 -> 递归结果实体
     * @DateTime： 2025/3/05 20:53
     **/
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TreeActionEntity {
        private RuleLogicCheckTypeVO ruleLogicCheckType;
        private StrategyAwardVO strategyAwardVO;
    }

    /**
     * @Author: 机智的赛尔
     * @Description： 决策树_内部流转策略奖品结果
     * @DateTime： 2025/3/05 20:53
     **/
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StrategyAwardVO {

        /** 抽奖奖品ID - 内部流转使用 */
        private Integer awardId;
        /** 抽奖奖品规则 */
        private String awardRuleValue;
    }

}
