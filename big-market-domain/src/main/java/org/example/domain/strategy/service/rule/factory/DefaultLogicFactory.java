package org.example.domain.strategy.service.rule.factory;


import org.example.domain.strategy.model.entity.RuleActionEntity;
import org.example.domain.strategy.service.annotation.LogicStrategy;
import org.example.domain.strategy.service.rule.ILogicFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @Author: 机智的赛尔
 * @Description： 规则工厂
 * @DateTime： 2025/2/25 10:06
 **/

@Service
public class DefaultLogicFactory {

    public Map<String, ILogicFilter<?>> logicFilterMap = new ConcurrentHashMap<>();

    /** 有一点复杂的构造函数 */
    public DefaultLogicFactory(List<ILogicFilter<?>> logicFilters) {
        logicFilters.forEach(logic -> {
            //对每一个过滤器检查它的注解
            LogicStrategy strategy = AnnotationUtils.findAnnotation(logic.getClass(), LogicStrategy.class);
            if (null != strategy) {
                logicFilterMap.put(strategy.logicMode().getCode(), logic);
            }
        });
    }

    /** 返回这个 */
    public <T extends RuleActionEntity.RaffleEntity> Map<String, ILogicFilter<T>> openLogicFilter() {
        return (Map<String, ILogicFilter<T>>) (Map<?, ?>) logicFilterMap;
    }

    @Getter
    @AllArgsConstructor
    public enum LogicModel {

        RULE_WIGHT("rule_weight","【抽奖前规则】根据抽奖权重返回可抽奖范围KEY","before"),
        RULE_BLACKLIST("rule_blacklist","【抽奖前规则】黑名单规则过滤，命中黑名单则直接返回","before"),
        RULE_LOCK("rule_lock","【抽奖中规则】抽奖n次，对应奖品可解锁抽奖","center"),
        RULE_LUCK_AWARD("rule_luck_award","【抽奖后规则】幸运奖兜底","after"),

        ;

        private final String code;
        private final String info;
        private final String type;

        public static boolean isCenter(String code) {
            //语法解析：其中valueof指的是选择枚举类中的某一个枚举量
            return  "center".equals(LogicModel.valueOf(code.toUpperCase()).type);
        }

        public static boolean isAfter(String code) {
            return  "after".equals(LogicModel.valueOf(code.toUpperCase()).type);
        }

    }

}


