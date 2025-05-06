package org.example.domain.credit.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.checkerframework.checker.units.qual.A;

/**
 * @Author: 机智的赛尔
 * @Description： 交易名称枚举值
 * @DateTime： 2025/5/6 15:57
 **/

@Getter
@AllArgsConstructor
public enum TradeNameVO {

    REBATE("行为返利"),
    CONVERT_SKU("兑换抽奖");

    ;

    private final String name;


}
