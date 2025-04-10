package org.example.infrastructure.persistent.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.UserAwardRecord;

/**
 * @Author: 机智的赛尔
 * @Description： 用户中奖记录表
 * @DateTime： 2025/3/28 17:58
 **/

@Mapper
public interface IUserAwardRecordDao {

    void insert(UserAwardRecord userAwardRecord);

}
