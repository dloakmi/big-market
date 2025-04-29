package org.example.domain.award.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: 机智的赛尔
 * @Description： 账户状态枚举
 * @DateTime： 2025/4/29 10:35
 **/

@Getter
@AllArgsConstructor
public enum AccountStatusVO {

    open("open", "开启"),
    close("close", "冻结"),
    ;

    private final String code;
    private final String desc;

}

