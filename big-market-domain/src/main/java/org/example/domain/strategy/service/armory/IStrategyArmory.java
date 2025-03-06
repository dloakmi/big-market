package org.example.domain.strategy.service.armory;

/**
 * @Author: 机智的赛尔
 * @Description： 策略装配库（兵工厂），负责初始化策略计算
 * @DateTime： 2025/2/21 18:10
 **/

public interface IStrategyArmory {


    /**
     * @description: 装配抽奖策略配置「触发的时机可以为活动审核通过后进行调用」
     * @author: 超级机智的赛尔
     * @date: 2025/3/6 15:17
     * @param strategyId 策略ID
     * @Return: 装配结果
     **/
    boolean assembleLotteryStrategy(Long strategyId);

}

