package org.example.domain.activity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Author: 机智的赛尔
 * @Description： 活动sku实体对象
 * @DateTime： 2025/3/24 10:56
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivitySkuEntity {

    /** 商品sku */
    private Long sku;
    /** 活动ID */
    private Long activityId;
    /** 活动个人(普通人) 参数ID (拆开) --> 在这个活动sku上，一个人可参与(使用)多少次活动sku（总、日、月） */
    private Long activityCountId;
    /** 库存总量 */
    private Integer stockCount;
    /** 剩余库存 */
    private Integer stockCountSurplus;

}
