package org.example.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: 机智的赛尔
 * @Description： 活动状态值对象
 * @DateTime： 2025/3/24 10:45
 **/

@Getter
@AllArgsConstructor
public enum ActivityStateVO {

    create("create", "创建"),
    open("open", "开启"),
    close("close", "关闭"),
    ;

    private final String code;
    private final String desc;


}
