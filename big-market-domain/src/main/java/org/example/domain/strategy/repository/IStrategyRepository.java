package org.example.domain.strategy.repository;

import org.example.domain.strategy.model.entity.StrategyAwardEntity;

import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： ****
 * @DateTime： 2025/2/21 19:27
 **/

public interface IStrategyRepository {


    List<StrategyAwardEntity> queryStrategyAwardlist(Long strategyId);
}
