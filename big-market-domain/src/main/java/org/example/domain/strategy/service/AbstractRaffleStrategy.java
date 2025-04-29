package org.example.domain.strategy.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.domain.strategy.model.entity.RaffleAwardEntity;
import org.example.domain.strategy.model.entity.RaffleFactorEntity;
import org.example.domain.strategy.model.entity.StrategyAwardEntity;
import org.example.domain.strategy.repository.IStrategyRepository;
import org.example.domain.strategy.service.armory.IStrategyDispatch;
import org.example.domain.strategy.service.rule.chain.factory.DefaultChainFactory;
import org.example.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import org.example.types.enums.ResponseCode;
import org.example.types.exception.AppException;

import java.util.Date;


/**
 * @Author: 机智的赛尔
 * @Description： 抽奖策略抽象类，定义抽奖的标准流程
 * @DateTime： 2025/2/25 10:01
 **/

@Slf4j
public abstract class AbstractRaffleStrategy implements IRaffleStrategy {


    protected IStrategyRepository repository;

    protected IStrategyDispatch strategyDispatch;

    // 抽奖前 - 责任链
    protected final DefaultChainFactory defaultChainFactory;

    // 抽奖后 - 决策树
    protected final DefaultTreeFactory defaultTreeFactory;

    public AbstractRaffleStrategy(IStrategyRepository repository, IStrategyDispatch strategyDispatch, DefaultChainFactory defaultChainFactory, DefaultTreeFactory defaultTreeFactory) {
        this.repository = repository;
        this.strategyDispatch = strategyDispatch;
        this.defaultChainFactory = defaultChainFactory;
        this.defaultTreeFactory = defaultTreeFactory;
    }

    @Override
    public RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity) {

        // 1. 参数校验
        String userId = raffleFactorEntity.getUserId();
        Long strategyId = raffleFactorEntity.getStrategyId();
        if (null == strategyId || StringUtils.isBlank(userId)) {
            throw new AppException(ResponseCode.ILLEGAL_PARAMETER.getCode(), ResponseCode.ILLEGAL_PARAMETER.getInfo());
        }

        // 2.责任链抽奖计算【这步拿到的初步的抽奖ID，之后需要根据ID处理抽奖】注意：黑名单、权重等非默认抽奖的直接返回抽奖结果
        DefaultChainFactory.StrategyAwardVO chainStrategyAwardVO = raffleLogicChain(userId, strategyId);
        log.info("抽奖策略计算-责任链: {} {} {} {}",userId,strategyId, chainStrategyAwardVO.getAwardId(), chainStrategyAwardVO.getLogicModel());

        // 如果是黑名单的话，不能走完全部的责任链
        if(!chainStrategyAwardVO.getLogicModel().equals(DefaultChainFactory.LogicModel.RULE_DEFAULT.getCode())) {
            return bulidRaffleAwardEntity(strategyId,chainStrategyAwardVO.getAwardId(), chainStrategyAwardVO.getAwardRuleValue());
        }

        // 3.规则树抽奖过滤【奖品ID，会根据抽奖次数判断、库存判断、兜底兜里返回最终的可获得奖品信息】
        DefaultTreeFactory.StrategyAwardVO treeStrategyAwardVO = raffleLogicTree(userId, strategyId, chainStrategyAwardVO.getAwardId(), raffleFactorEntity.getEndDate());
        log.info("抽奖策略计算-规则树 {} {} {} {}",userId,strategyId,treeStrategyAwardVO.getAwardId(),treeStrategyAwardVO.getAwardRuleValue());

        // 4.返回最终结构
        return bulidRaffleAwardEntity(strategyId,treeStrategyAwardVO.getAwardId(),treeStrategyAwardVO.getAwardRuleValue());
        
    }
    /**
     * @description: 构建抽奖结果
     * @author: 超级机智的赛尔
     * @date: 2025/3/15 12:33
     * @param strategyId 策略ID
     * @param awardId 奖品ID
     * @param awardConfig 奖品配置信息
     * @Return: 抽奖结果
     **/
    private RaffleAwardEntity bulidRaffleAwardEntity(Long strategyId, Integer awardId, String awardConfig) {
        StrategyAwardEntity strategyAward = repository.queryStrategyAwardEntity(strategyId,awardId);
        return RaffleAwardEntity.builder()
                .awardId(awardId)
                .awardConfig(awardConfig)
                .awardTitle(strategyAward.getAwardTitle())
                .sort(strategyAward.getSort())
                .build();
    }


    /**
     * @description: 抽象计算，责任链方法
     * @author: 超级机智的赛尔
     * @date: 2025/3/5 10:23
     * @param userId     用户ID
     * @param strategyId 策略ID
     * @Return: 奖品ID
     **/
    public abstract DefaultChainFactory.StrategyAwardVO raffleLogicChain(String userId , Long strategyId);

    /**
     * @description: 抽奖结果过滤，决策树方法
     * @author: 超级机智的赛尔
     * @date: 2025/3/5 10:20
     * @param userId     用户ID
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     * @Return: 过滤结果【奖品ID，会根据抽奖次数判断、库存判断、兜底兜里返回最终的可获得奖品信息】
     **/
    public abstract DefaultTreeFactory.StrategyAwardVO raffleLogicTree(String userId , Long strategyId, Integer awardId);


    /**
     * @description: 抽奖结果过滤，决策树方法
     * @author: 超级机智的赛尔
     * @date: 2025/3/5 10:20
     * @param userId        用户ID
     * @param strategyId    策略ID
     * @param awardId       奖品ID
     * @param endDateTime   活动结束时间
     * @Return: 过滤结果【奖品ID，会根据抽奖次数判断、库存判断、兜底兜里返回最终的可获得奖品信息】
     **/
    public abstract DefaultTreeFactory.StrategyAwardVO raffleLogicTree(String userId , Long strategyId, Integer awardId, Date endDateTime);

}

