package org.example.domain.task.model.entity;

import lombok.Data;

/**
 * @Author: 机智的赛尔
 * @Description： 任务实体对象
 * @DateTime： 2025/4/10 16:53
 **/

@Data
public class TaskEntity {

    /** 活动ID */
    private String userId;
    /** 消息主题 */
    private String topic;
    /** 消息编号 */
    private String messageId;
    /** 消息主体 */
    private String message;



}
