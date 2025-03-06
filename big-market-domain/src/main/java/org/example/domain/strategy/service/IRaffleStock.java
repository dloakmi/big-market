package org.example.domain.strategy.service;

import org.example.domain.strategy.model.valobj.StrategyAwardStockKeyVO;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖库存相关服务，获取库存消耗队列
 * @DateTime： 2025/3/6 15:11
 **/

public interface IRaffleStock {

    /**
     * @description: 获取奖品库存消耗队列
     * @author: 超级机智的赛尔
     * @date: 2025/3/6 15:13
     * @throws InterruptedException 异常
     * @Return: 奖品库存key信息
     **/
    StrategyAwardStockKeyVO takeQueueValue() throws InterruptedException;

    /**
     * @description: 更新奖品库存消耗记录
     * @author: 超级机智的赛尔
     * @date: 2025/3/6 16:52
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     * @Return: void
     **/
    void updateStrategyAwardStock(Long strategyId, Integer awardId);

}
