package org.example.domain.award.repository;

import org.example.domain.award.model.GiveOutPrizesAggregate;
import org.example.domain.award.model.aggregate.UserAwardRecordAggregate;
import org.example.domain.award.model.entity.UserAwardRecordEntity;

/**
 * @Author: 机智的赛尔
 * @Description： 奖品仓储服务
 * @DateTime： 2025/4/9 16:48
 **/

public interface IAwardRepository {

    void saveUserAwardRecord(UserAwardRecordAggregate userAwardRecordAggregate);

    String queryAwardConfig(Integer awardId);

    void saveGiveOutPrizesAggregate(GiveOutPrizesAggregate giveOutPrizesAggregate);

    String queryAwardKey(Integer awardId);
}
