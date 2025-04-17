package org.example.domain.rebate.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: 机智的赛尔
 * @Description： 任务值对象
 * @DateTime： 2025/4/17 14:47
 **/

@Getter
@AllArgsConstructor
public enum TaskStateVO {

    create("create", "创建"),
    complete("complete", "发送完成"),
    fail("fail", "发送失败"),
    ;


    private final String code;
    private final String des;

}
