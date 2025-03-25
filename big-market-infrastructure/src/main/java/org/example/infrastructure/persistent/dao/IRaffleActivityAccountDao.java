package org.example.infrastructure.persistent.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.RaffleActivityAccount;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖活动账户表
 * @DateTime： 2025/3/22 10:00
 **/

@Mapper
public interface IRaffleActivityAccountDao {

    int updateAccountQuota(RaffleActivityAccount raffleActivityAccount);

    void insert(RaffleActivityAccount raffleActivityAccount);
}
