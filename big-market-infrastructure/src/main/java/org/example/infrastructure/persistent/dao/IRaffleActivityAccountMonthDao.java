package org.example.infrastructure.persistent.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.RaffleActivityAccountMonth;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖活动账户表-月次数
 * @DateTime： 2025/3/28 17:57
 **/

@Mapper
public interface IRaffleActivityAccountMonthDao {

    int updateActivityAccountMonthSubtractionQuota(RaffleActivityAccountMonth raffleActivityAccountMonth);

    void insertActivityAccountMonth(RaffleActivityAccountMonth raffleActivityAccountMonth);

    @DBRouter
    RaffleActivityAccountMonth queryActivityAccountMonthByUserId(RaffleActivityAccountMonth raffleActivityAccountMonthReq);

    int updateAccountQuota(RaffleActivityAccountMonth raffleActivityAccountMonth);
}
