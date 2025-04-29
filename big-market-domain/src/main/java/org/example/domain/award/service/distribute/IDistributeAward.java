package org.example.domain.award.service.distribute;

import org.example.domain.award.model.entity.DistributeAwardEntity;

/**
 * @Author: 机智的赛尔
 * @Description： 分发奖品接口
 * @DateTime： 2025/4/28 14:40
 **/

public interface IDistributeAward {

    void giveOutPrizes(DistributeAwardEntity distributeAwardEntity);

}
