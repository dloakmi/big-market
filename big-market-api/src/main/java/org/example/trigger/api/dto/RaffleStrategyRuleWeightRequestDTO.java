package org.example.trigger.api.dto;

import lombok.Data;

/**
 * @Author: 机智的赛尔
 * @Description： ****
 * @DateTime： 2025/4/24 11:10
 **/

@Data
public class RaffleStrategyRuleWeightRequestDTO {

    /** 用户ID */
    private String userId;
    /** 活动ID */
    private Long activityId;
}
