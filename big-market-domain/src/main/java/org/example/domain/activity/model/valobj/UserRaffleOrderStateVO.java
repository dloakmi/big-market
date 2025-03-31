package org.example.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: 机智的赛尔
 * @Description： 用户抽奖订单状态枚举
 * @DateTime： 2025/3/31 12:24
 **/

@Getter
@AllArgsConstructor
public enum UserRaffleOrderStateVO {

    create("create","创建"),
    used("used","已使用"),
    cancel("cancel","已作废")
    ;

    private final String code;
    private final String desc;

}
