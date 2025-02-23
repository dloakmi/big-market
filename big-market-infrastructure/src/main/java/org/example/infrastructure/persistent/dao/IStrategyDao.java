package org.example.infrastructure.persistent.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.Strategy;

import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： 策略表 Dao
 * @DateTime： 2025/2/21 13:42
 **/

@Mapper
public interface IStrategyDao {
    List<Strategy> queryStrategyList();

    Strategy queryStrategyByStrategyId(Long strategyId);
}
