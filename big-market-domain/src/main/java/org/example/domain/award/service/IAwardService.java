package org.example.domain.award.service;

import org.example.domain.award.model.entity.UserAwardRecordEntity;

/**
 * @Author: 机智的赛尔
 * @Description： 奖品服务接口
 * @DateTime： 2025/4/8 17:53
 **/

public interface IAwardService {

    /**
     * @description: 存储用户抽奖奖品记录
     * @author: 超级机智的赛尔
     * @date: 2025/4/17 10:44
     * @param userAwardRecordEntity 用户抽奖记录实体
     * @Return: void
     **/
    void saveUserAwardRecord(UserAwardRecordEntity userAwardRecordEntity);

}
