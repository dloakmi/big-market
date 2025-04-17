package org.example.domain.rebate.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: 机智的赛尔
 * @Description： 行为类星星枚举值对象
 * @DateTime： 2025/4/17 13:34
 **/

@Getter
@AllArgsConstructor
public enum BehaviorTypeVO {

    SIGN("sign","签到(日历)"),
    OPEN_PAY("openai_pay","openai 外部支付"),
    ;


    private final String code;

    private final String info;
}
