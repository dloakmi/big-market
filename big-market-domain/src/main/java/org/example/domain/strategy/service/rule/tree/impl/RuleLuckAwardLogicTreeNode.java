package org.example.domain.strategy.service.rule.tree.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import org.example.domain.strategy.service.rule.tree.ILogicTreeNode;
import org.example.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import org.example.types.common.Constants;
import org.springframework.stereotype.Component;

/**
 * @Author: 机智的赛尔
 * @Description： 兜底奖励节点
 * @DateTime： 2025/3/3 21:05
 **/

@Slf4j
@Component("rule_luck_award")
public class RuleLuckAwardLogicTreeNode implements ILogicTreeNode {

    @Override
    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId,String ruleValue) {

        log.info("规则过滤-兜底奖品 userId:{} strategyId:{} awardId:{} ruleValue: {}", userId, strategyId, awardId, ruleValue);
        String[] split = ruleValue.split(Constants.COLON);

        if(split.length == 0){
            log.error("规则过滤-兜底奖品，兜底奖品未配置告警 userId:{} strategyId:{} awardId:{} ruleValue: {}", userId, strategyId, awardId, ruleValue);
            //看看传来的东西到底是什么
            throw new RuntimeException("兜底奖品未设置,这设置的是啥？" + ruleValue);
        }

        // 兜底奖励配置
        Integer luckAwardId = Integer.valueOf(split[0]);
        String awardRuleValue = split.length > 1 ? split[1] : "";
        // 返回兜底奖品
        log.info("规则过滤-兜底奖品第二弹 userId:{} strategyId:{} awardId:{} ruleValue: {}", userId, strategyId, awardId, ruleValue);
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckType(RuleLogicCheckTypeVO.TAKE_OVER)
                .strategyAwardVO(DefaultTreeFactory.StrategyAwardVO.builder()
                        .awardId(luckAwardId)
                        .awardRuleValue(awardRuleValue)
                        .build())
                .build();


    }

}

