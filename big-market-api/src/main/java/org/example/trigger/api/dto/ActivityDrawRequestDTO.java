package org.example.trigger.api.dto;

import lombok.Data;

/**
 * @Author: 机智的赛尔
 * @Description： 活动抽奖请求对象
 * @DateTime： 2025/4/12 17:00
 **/

@Data
public class ActivityDrawRequestDTO {

    /** 用户ID */
    private String userId;

    /** 活动ID */
    private Long activityId;
}
