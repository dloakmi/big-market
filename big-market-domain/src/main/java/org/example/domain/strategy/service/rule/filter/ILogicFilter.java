package org.example.domain.strategy.service.rule.filter;

import org.example.domain.strategy.model.entity.RuleActionEntity;
import org.example.domain.strategy.model.entity.RuleMatterEntity;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖规则过滤接口 (包括抽奖前-中-后)
 * @DateTime： 2025/2/25 9:43
 **/

public interface ILogicFilter<T extends RuleActionEntity.RaffleEntity> {
    
   /**
    * @description: 过滤器——在抽奖的前中后
    * @author: 超级机智的赛尔
    * @date: 2025/2/25 9:50
    * @param: ruleMatterEntity
    * @Return: 抽奖执行实体
    **/
    RuleActionEntity<T> filter(RuleMatterEntity ruleMatterEntity);

}

