package org.example.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 机智的赛尔
 * @Description： 任务表，发送MQ
 * @DateTime： 2025/3/28 17:54
 **/

@Data
public class Task {

    /** 自增ID */
    private String id;
    /** 用户ID*/
    private String userId;
    /** 消息主题 */
    private String topic;
    /** 消息编号 */
    private String messageId;
    /** 消息主体 */
    private String message;
    /** 任务状态；create-创建、completed-完成、fail-失败 */
    private String state;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;


}
