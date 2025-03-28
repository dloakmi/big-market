package org.example.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖活动账户表-月次数
 * @DateTime： 2025/3/28 17:54
 **/
@Data
public class RaffleActivityAccountMonth {

    /** 自增ID */
    private String id;
    /** 用户ID */
    private String userId;
    /** 活动ID */
    private Long activityId;
    /** 月（yyyy-mm） */
    private String month;
    /** 月次数 */
    private Integer monthCount;
    /** 月次数-剩余 */
    private Integer monthCountSurplus;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

}
