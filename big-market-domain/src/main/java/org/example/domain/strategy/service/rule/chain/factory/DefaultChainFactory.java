package org.example.domain.strategy.service.rule.chain.factory;

import org.example.domain.strategy.model.entity.StrategyEntity;
import org.example.domain.strategy.repository.IStrategyRepository;
import org.example.domain.strategy.service.rule.chain.ILogicChain;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: 机智的赛尔
 * @Description： 规则工厂_责任链
 * @DateTime： 2025/2/26 20:53
 **/

@Service
public class DefaultChainFactory {

    private final Map<String, ILogicChain> logicChainGroup;

    private final IStrategyRepository repository;

    public DefaultChainFactory(Map<String, ILogicChain> logicChainGroup, IStrategyRepository repository) {
        this.logicChainGroup = logicChainGroup;
        this.repository = repository;
    }

    /**
     * @description: 开启 过滤方法_责任链
     * @author: 超级机智的赛尔
     * @date: 2025/2/26 21:14
     * @param: strategyId 策略ID
     * @Return: 一个责任链
     **/
    public ILogicChain openLogicChain(Long strategyId) {
        StrategyEntity strategy = repository.queryStrategyEntityByStrategyId(strategyId);
        String[] ruleModels = strategy.ruleModels();

        //咱没关系就走默认的呗
        if(ruleModels == null || ruleModels.length==0)return logicChainGroup.get("default");

        //把策略Id对应过滤方法全部塞进去
        ILogicChain logicChain = logicChainGroup.get(ruleModels[0]);
        ILogicChain point = logicChain;
        for (int i = 1; i < ruleModels.length; i++) {
            ILogicChain nextChain = logicChainGroup.get(ruleModels[i]);
            point.appendNext(nextChain);
            point = nextChain;
        }
        point.appendNext(logicChainGroup.get("default"));

        return logicChain;

    }

}
