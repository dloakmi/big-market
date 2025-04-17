package org.example.domain.strategy.service;

import java.util.Map;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖规则接口
 * @DateTime： 2025/4/15 9:37
 **/

public interface IRaffleRule {

    /**
     * @description: 查询奖品限制次数 例： A奖品 - 抽三次解锁
     * @author: 超级机智的赛尔
     * @date: 2025/4/17 10:46
     * @param treeIds 奖品列表
     * @Return: 奖品列表对应的限制hashmap
     **/
    Map<String,Integer> queryAwardRuleLockAction(String[] treeIds);

}
