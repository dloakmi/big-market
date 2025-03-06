package org.example.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖策略规则规则值对象；值对象，没有唯一ID，仅限于从数据库查询对象
 * @DateTime： 2025/2/26 15:27
 **/


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardRuleModelVO {

    private  String ruleModels;

}
