package org.example.domain.strategy.repository;

import org.example.domain.strategy.model.entity.StrategyAwardEntity;
import org.example.domain.strategy.model.entity.StrategyEntity;
import org.example.domain.strategy.model.entity.StrategyRuleEntity;
import org.example.domain.strategy.model.valobj.RuleTreeVO;
import org.example.domain.strategy.model.valobj.StrategyAwardRuleModelVO;
import org.example.domain.strategy.model.valobj.StrategyAwardStockKeyVO;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 机智的赛尔
 * @Description：策略仓储接口
 * @DateTime： 2025/2/21 19:27
 **/

public interface IStrategyRepository {

    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTable(String key, Integer rateRange, Map<Integer, Integer> strategyAwardSearchRateTable);

    Integer getStrategyAwardAssemble(String key, Integer rateKey);
    /**
     * @description: 获取抽奖的范围，以及检测是否已经前置装配
     * @author: 超级机智的赛尔
     * @date: 2025/3/15 13:59
     * @param strategyId 策略ID
     * @Return: 抽奖范围
     **/
    int getRateRange(Long strategyId);
    /**
     * @description: 获取抽奖的范围，以及检测是否已经前置装配
     * @author: 超级机智的赛尔
     * @date: 2025/3/15 13:58
     * @param key 策略ID
     * @Return: 抽奖范围
     **/
    int getRateRange(String key);
    /**
     * @description: 通过策略ID查询策略信息
     * @author: 超级机智的赛尔
     * @date: 2025/3/5 12:43
     * @param strategyId 策略ID
     * @Return: 策略实体信息
     **/
    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);

    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);

    /**
     * @description: 根据策略ID以及限制方法 -> 限制方法的值
     * @author: 超级机智的赛尔
     * @date: 2025/3/6 11:05
     * @param strategyId 策略ID
     * @param ruleModel 限制方法名
     * @Return: 限制方法的值
     **/
    String queryStrategyRuleValue(Long strategyId,  String ruleModel);

    /**
     * @description: 根据策略ID以及奖品ID获取对应奖品是否还有其他限制
     * @author: 超级机智的赛尔
     * @date: 2025/3/5 13:57
     * @param strategyId   策略ID
     * @param awardId      奖品ID
     * @Return: 对应奖品的额外限制
     **/
    StrategyAwardRuleModelVO queryStrategyAwardRuleModelVO(Long strategyId, Integer awardId);
    
    /**
     * @description: 根据规则树ID，查询树结构信息，并构建规则树对象
     * @author: 超级机智的赛尔
     * @date: 2025/3/4 15:52
     * @param treeId 规则树ID
     * @Return: 树结构信息
     **/
    RuleTreeVO queryRuleTreeVOByTreeId(String treeId);

    /**
     * @description: 缓存奖品库存
     * @author: 超级机智的赛尔
     * @date: 2025/3/5 16:59
     * @param cacheKey   key
     * @param awardCount 库存值
     * @Return: void
     **/
    void cacheStrategyAwardCount(String cacheKey, Integer awardCount);

    /**
     * @description: 缓存key，decr方式扣减库存
     * @author: 超级机智的赛尔
     * @date: 2025/3/6 11:03
     * @param cacheKey 缓存key
     * @Return: 扣减结果
     **/
    Boolean subtractionAwardStock(String cacheKey);

    void awardStockConsumeSendQueue(StrategyAwardStockKeyVO strategyAwardStockKeyVO);

    /**
     * @description: 获取队列值
     * @author: 超级机智的赛尔
     * @date: 2025/3/6 16:56
     * @Return: 队列
     **/
    StrategyAwardStockKeyVO takeQueueValue();

    void updateStrategyAwardStock(Long strategyId, Integer awardId);

    StrategyAwardEntity queryStrategyAwardEntity(Long strategyId, Integer awardId);
}


