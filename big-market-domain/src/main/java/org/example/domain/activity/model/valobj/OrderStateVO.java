package org.example.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: 机智的赛尔
 * @Description： 订单状态枚举值对象（用于描述对象属性的值，如枚举，不影响数据库操作的对象，无生命周期）
 * @DateTime： 2025/3/24 10:47
 **/

@Getter
@AllArgsConstructor
public enum OrderStateVO {

    completed("completed", "完成");

    private final String code;
    private final String desc;

}

