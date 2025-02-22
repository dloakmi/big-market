package org.example.domain.strategy.repository;

import org.example.domain.strategy.model.entity.StrategyAwardEntity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description：策略仓储接口
 * @DateTime： 2025/2/21 19:27
 **/

public interface IStrategyRepository {


    List<StrategyAwardEntity> queryStrategyAwardlist(Long strategyId);

    void storeStrategyAwardSearchRateTables(Long strategyId, Integer rateRange, HashMap<Integer, Integer> shuffledStrategyAwardSearchRateTable);

    int getRateRange(Long strategyId);

    int getStrategyAwardAssemble(Long strategyId, int ratekey);
}
