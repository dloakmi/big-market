package org.example.domain.activity.model.entity;

import lombok.Getter;

/**
 * @Author: 机智的赛尔
 * @Description： 活动商品充值实体对象
 * @DateTime： 2025/3/24 14:21
 **/

@Getter
public class SkuRechargeEntity {

    /**
     * 用户ID
     **/
    private String userId;

    /**
     * 商品SKU - activity + activity count
     **/
    private Long sku;

    /**
     * 幂等专业单号，外部谁充值谁透传，这样来保证幂
     **/
    private String outBusinessNo;


}
