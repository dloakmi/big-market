package org.example.domain.strategy.service.armory;

/**
 * @author MSI
 * @date 2025/2/23 18:56
 * @description: 策略抽奖调度
 */


public interface IStrategyDispatch {

    /**
     * @description: 获取抽奖策略装配的随机结果
     * @author: 超级机智的赛尔
     * @date: 2025/2/25 14:21
     * @param: strategyId 策略ID
     * @Return: 抽奖结果
     **/
    Integer getRandomAwardId(Long strategyId);
    /**
     * @description: 获取抽奖策略装配的随机结果
     * @author: 超级机智的赛尔
     * @date: 2025/3/5 17:29
     * @param: strategyId  策略ID
     * @param: ruleWeightValue 权重ID
     * @Return: 抽奖结果
     **/
    Integer getRandomAwardId(Long strategyId, String ruleWeightValue);

    Boolean subtractionAwardStock(Long strategyId , Integer awardId);


}
