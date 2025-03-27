package org.example.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 机智的赛尔
 * @Description： 活动sku库存 key 值对象
 * @DateTime： 2025/3/27 10:57
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivitySkuStockKeyVO {

    /**
     * 商品sku
     **/
    private Long sku;

    /**
     * 活动ID
     **/
    private Long activityId;


}
