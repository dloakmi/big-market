package org.example.domain.strategy.service;

import java.util.Map;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖规则接口
 * @DateTime： 2025/4/15 9:37
 **/

public interface IRaffleRule {

    Map<String,Integer> queryAwardRuleLockAction(String[] treeIds);

}
