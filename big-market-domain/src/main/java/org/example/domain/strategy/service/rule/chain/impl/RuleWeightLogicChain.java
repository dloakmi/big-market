package org.example.domain.strategy.service.rule.chain.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.strategy.repository.IStrategyRepository;
import org.example.domain.strategy.service.armory.IStrategyDispatch;
import org.example.domain.strategy.service.rule.chain.AbstractLogicChain;
import org.example.types.common.Constants;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author: 机智的赛尔
 * @Description： 权重_责任链
 * @DateTime： 2025/2/26 19:51
 **/

@Slf4j
@Component("rule_weight")
public class RuleWeightLogicChain extends AbstractLogicChain {

    @Resource
    private IStrategyRepository repository;

    @Resource
    private IStrategyDispatch strategyDispatch;

    //等待被mock
    public Long userScore =  0L;

    @Override
    public Integer logic(String userId, Long strategyId) {
        log.info("规则过滤-权重范围 userId:{} strategyId:{} ruleModel:{}",userId,strategyId,ruleModel());

        // 1. 根据用户ID查询用户抽奖消耗的积分值，本章节我们先写死为固定的值。后续需要从数据库中查询。
        String ruleValue = repository.queryStrategyRuleValue(strategyId, ruleModel());
        Map<Long, String> analyticalValueGroup = getAnalyticalValue(ruleValue);
        if (null == analyticalValueGroup || analyticalValueGroup.isEmpty())return null;

        // 2. 转换Keys值，并默认排序
        List<Long> analyticalSortedKeys = new ArrayList<>(analyticalValueGroup.keySet());
        Collections.sort(analyticalSortedKeys);

        // 3.找到对应的积分限制位置
        Long nextValue = analyticalSortedKeys.stream()
                .sorted(Comparator.reverseOrder())
                .filter(analyticalSortedKey -> userScore > analyticalSortedKey)
                .findFirst()
                .orElse(null);

        // 4.抽奖！（还没发奖）
        if(null == nextValue){
            Integer awardId = strategyDispatch.getRandomAwardId(strategyId, analyticalValueGroup.get(nextValue));
            log.info("抽奖责任链—权重处理 userId:{} strategyId:{} ruleModel:{} ", userId, strategyId, ruleModel());
            return awardId;
        }


        return 0;
    }

    @Override
    protected String ruleModel() {
        return "rule_weight";
    }

    /**
     * @description: 将权重值结构成能用的形式
     * @author: 超级机智的赛尔
     * @date: 2025/2/25 17:28
     * @param: ruleValue 权重值
     * @Return: key —— 积分限度（4000） ；
     *          value —— 一排策略奖品id （102,103,104,105）
     **/
    private Map<Long, String> getAnalyticalValue(String ruleValue) {
        String[] ruleValueGroups = ruleValue.split(Constants.SPACE);
        Map<Long, String> ruleValueMap = new HashMap<>();
        for (String ruleValueKey : ruleValueGroups) {
            // 检查输入是否为空
            if (ruleValueKey == null || ruleValueKey.isEmpty()) {
                return ruleValueMap;
            }
            // 分割字符串以获取键和值
            String[] parts = ruleValueKey.split(Constants.COLON);
            if (parts.length != 2) {
                throw new IllegalArgumentException("rule_weight rule_rule invalid input format" + ruleValueKey);
            }
            ruleValueMap.put(Long.parseLong(parts[0]), ruleValueKey);
        }
        return ruleValueMap;
    }
}
