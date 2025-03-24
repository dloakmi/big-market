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


    /**
     * @description: 根据策略ID获取该策略对应的奖品表
     * @author: 超级机智的赛尔
     * @date: 2025/3/24 11:29
     * @param strategyId 策略ID
     * @Return: 奖品表
     **/
    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);
    /**
     * @description: 存储抽奖范围和抽奖表
     * @author: 超级机智的赛尔
     * @date: 2025/3/24 11:27
     * @param key redis的key键值
     * @param rateRange 抽奖范围
     * @param strategyAwardSearchRateTable 抽奖概率表
     * @Return:
     **/
    void storeStrategyAwardSearchRateTable(String key, Integer rateRange, Map<Integer, Integer> strategyAwardSearchRateTable);

    /**
     * @description: 根据随机值获取抽奖结果
     * @author: 超级机智的赛尔
     * @date: 2025/3/24 11:22
     * @param key 抽奖表的key键值
     * @param rateKey 随机值
     * @Return:
     **/
    Integer getStrategyAwardAssemble(String key, Integer rateKey);
    /**
     * @description: 获取抽奖的范围，顺便检测是否已经前置装配
     * @author: 超级机智的赛尔
     * @date: 2025/3/15 13:59
     * @param strategyId 策略ID
     * @Return: 抽奖范围
     **/
    int getRateRange(Long strategyId);
    /**
     * @description: 获取抽奖的范围，顺便检测是否已经前置装配
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

    /**
     * @description: 在策略装配时，根据策略ID和规则模型查询权重
     * @author: 超级机智的赛尔
     * @date: 2025/3/24 12:15
     * @param strategyId 策略ID
     * @param ruleModel 规则模型（黑名单，装配权重）
     * @Return: 包含权重的打包
     **/
    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);

    /**
     * @description: 在责任链时，根据策略ID和规则模型查询对应的权重
     * @author: 超级机智的赛尔
     * @date: 2025/3/24 12:31
     * @param strategyId 策略ID
     * @param awardId 奖品ID（暂时用不到）
     * @param ruleModel 规则模型
     * @Return:
     **/
    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);

    /**
     * @description: 在责任链时，根据策略ID和规则模型查询对应的权重
     * @author: 超级机智的赛尔
     * @date: 2025/3/6 11:05
     * @param strategyId 策略ID
     * @param ruleModel 规则模型
     * @Return: 权重值
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

    /**
     * @description: 讲奖品消耗加入消耗队列（加锁队列+延迟队列）
     * @author: 超级机智的赛尔
     * @date: 2025/3/24 12:33
     * @param: strategyAwardStockKeyVO 消耗品对象
     * @Return: void
     **/
    void awardStockConsumeSendQueue(StrategyAwardStockKeyVO strategyAwardStockKeyVO);

    /**
     * @description: 获取队列
     * @author: 超级机智的赛尔
     * @date: 2025/3/6 16:56
     * @Return: 队列
     **/
    StrategyAwardStockKeyVO takeQueueValue();

    /**
     * @description: 更新数据库仓储数量
     * @author: 超级机智的赛尔
     * @date: 2025/3/24 12:36
     * @param strategyId 策略ID
     * @param awardId 奖品ID
     * @Return: void
     **/
    void updateStrategyAwardStock(Long strategyId, Integer awardId);

    /**
     * @description: 根据策略ID和奖品ID获取奖品详细信息
     * @author: 超级机智的赛尔
     * @date: 2025/3/24 12:36
     * @param strategyId 策略ID
     * @param awardId 奖品ID
     * @Return: 关于奖品的详细信息
     **/
    StrategyAwardEntity queryStrategyAwardEntity(Long strategyId, Integer awardId);
}


