package org.example.domain.rebate.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: 机智的赛尔
 * @Description： 返利类型（sku 活动库存充值商品、integral 用户活动积分）
 * @DateTime： 2025/4/18 13:43
 **/

@Getter
@AllArgsConstructor
public enum RebateTypeVO {

    SKU("sku","活动库存充值商品"),
    INTEGRAL("integral","用户活动积分")
    ;

    private final String code;
    private final String info;

}
