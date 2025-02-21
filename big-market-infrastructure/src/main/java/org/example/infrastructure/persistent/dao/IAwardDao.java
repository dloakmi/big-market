package org.example.infrastructure.persistent.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.Award;

import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： 奖品表 Dao
 * @DateTime： 2025/2/21 13:40
 **/

@Mapper
public interface IAwardDao {

    List<Award> queryAwardList();
}
