package org.example.infrastructure.persistent.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.UserBehaviorRebateOrder;

/**
 * @Author: 机智的赛尔
 * @Description： 用户行为返利流水订单表
 * @DateTime： 2025/4/17 11:10
 **/

@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserBehaviorRebateOrderDao {


    void insert(UserBehaviorRebateOrder userBehaviorRebateOrder);

}
