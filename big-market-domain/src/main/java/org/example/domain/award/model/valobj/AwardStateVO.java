package org.example.domain.award.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: 机智的赛尔
 * @Description： ****
 * @DateTime： 2025/4/8 17:58
 **/

@Getter
@AllArgsConstructor
public enum AwardStateVO {

    create("create","创建"),
    ;

    private final String code;
    private final String desc;

}
