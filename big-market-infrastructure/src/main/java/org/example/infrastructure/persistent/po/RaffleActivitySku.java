package org.example.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖活动sku持久化对象
 * @DateTime： 2025/3/24 10:16
 **/

@Data
public class RaffleActivitySku {

    /**
     * 自增ID
     **/
    private Long id;

    /**
     * 商品sku
     */
    private Long sku;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 活动个人参与次数ID
     */
    private Long activityCountId;
    /**
     * 库存总量
     */
    private Integer stockCount;
    /**
     * 剩余库存
     */
    private Integer stockCountSurplus;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}
