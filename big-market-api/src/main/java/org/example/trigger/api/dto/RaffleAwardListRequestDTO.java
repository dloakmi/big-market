package org.example.trigger.api.dto;

import lombok.Data;


/**
 * @Author: 机智的赛尔
 * @Description： 抽奖奖品列表，请求对象
 * @DateTime： 2025/3/13 13:10
 **/
@Data
public class RaffleAwardListRequestDTO {

    // 抽奖策略ID
    @Deprecated
    private Long strategyId;
    // 活动ID
    private Long activityId;
    // 用户ID
    private String userId;
}
