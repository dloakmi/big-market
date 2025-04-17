package org.example.infrastructure.persistent.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.DailyBehaviorRebate;

import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： 日常行为返利活动配置
 * @DateTime： 2025/4/17 11:09
 **/

@Mapper
public interface IDailyBehaviorRebateDao {

    List<DailyBehaviorRebate> queryDailyBehaviorRebateByBehaviorType(String code);

}
