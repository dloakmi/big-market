package org.example.domain.activity.model.entity;

import lombok.Data;

/**
 * @Author: 机智的赛尔
 * @Description： 参与抽奖活动实体对象
 * @DateTime： 2025/3/31 12:17
 **/

@Data
public class PartakeRaffleActivityEntity {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

}

