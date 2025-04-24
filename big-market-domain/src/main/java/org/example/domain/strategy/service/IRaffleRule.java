package org.example.domain.strategy.service;

import org.example.domain.strategy.model.valobj.RuleWeightVO;

import java.util.List;
import java.util.Map;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖规则接口
 * @DateTime： 2025/4/15 9:37
 **/

public interface IRaffleRule {

    /**
     * @description: 查询奖品限制次数 例： A奖品 - 抽三次解锁
     * @author: 超级机智的赛尔
     * @date: 2025/4/17 10:46
     * @param treeIds 奖品列表
     * @Return: 奖品列表对应的限制hashmap
     **/
    Map<String,Integer> queryAwardRuleLockAction(String[] treeIds);

    /**
     * @description: 通过策略ID查询奖品权重对象 (对内)
     * @author: 超级机智的赛尔
     * @date: 2025/4/24 16:23
     * @param StrategyId 策略ID
     * @Return: 奖品权重对象
     **/
    List<RuleWeightVO> queryAwardRuleWeightByStrategyId(Long StrategyId);

    /**
     * @description: 通过活动ID查询奖品权重值对象 (对外)
     * @author: 超级机智的赛尔
     * @date: 2025/4/24 16:24
     * @param activityId 活动ID
     * @Return: 奖品权重值对象
     **/
    List<RuleWeightVO> queryAwardRuleWeightByActivityId(Long activityId);
}
