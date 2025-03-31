package org.example.infrastructure.persistent.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.UserRaffleOrder;

/**
 * @Author: 机智的赛尔
 * @Description： 用户抽奖订单表
 * @DateTime： 2025/3/28 17:58
 **/

@Mapper
public interface IUserRaffleOrderDao {

    void insert(UserRaffleOrder userRaffleOrder);

    @DBRouter
    UserRaffleOrder queryNoUsedRaffleOrder(UserRaffleOrder userRaffleOrderReq);
}
