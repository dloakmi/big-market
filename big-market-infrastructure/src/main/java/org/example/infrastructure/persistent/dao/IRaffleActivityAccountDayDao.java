package org.example.infrastructure.persistent.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.RaffleActivityAccountDay;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖活动账户表-日次数
 * @DateTime： 2025/3/28 17:57
 **/
@Mapper
public interface IRaffleActivityAccountDayDao {

    int updateActivityAccountDaySubtractionQuota(RaffleActivityAccountDay build);

    void insertActivityAccountDay(RaffleActivityAccountDay build);

    @DBRouter
    RaffleActivityAccountDay queryActivityAccountDayByUserId(RaffleActivityAccountDay raffleActivityAccountDayReq);
}
