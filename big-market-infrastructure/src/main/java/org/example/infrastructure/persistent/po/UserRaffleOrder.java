package org.example.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 机智的赛尔
 * @Description： ****
 * @DateTime： 2025/3/28 17:56
 **/

@Data
public class UserRaffleOrder {

    /** 用户ID */
    private String id;
    /** 活动ID */
    private String userId;
    /** 活动名称 */
    private Long activityId;
    /** 抽奖策略ID */
    private String activityName;
    /** 订单ID */
    private Long strategyId;
    /** 下单时间 */
    private String orderId;
    /** 订单状态；create-创建、used-已使用、cancel-已作废 */
    private Date orderTime;
    /** 创建时间 */
    private String orderState;
    /** 更新时间 */
    private Date createTime;
    /**  */
    private Date updateTime;



}
