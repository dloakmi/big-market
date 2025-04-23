package org.example.trigger.api.dto;

import lombok.Data;

/**
 * @Author: 机智的赛尔
 * @Description： 用户活动账户查询对象
 * @DateTime： 2025/4/23 16:12
 **/

@Data
public class UserActivityAccountRequestDTO {

    private String userId;

    private Long activityId;


}
