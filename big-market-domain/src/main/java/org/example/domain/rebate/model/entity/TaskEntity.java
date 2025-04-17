package org.example.domain.rebate.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.award.event.SendAwardMessageEvent;
import org.example.domain.award.model.valobj.TaskStateVO;
import org.example.domain.rebate.event.SendRebateMessageEvent;
import org.example.types.event.BaseEvent;

/**
 * @Author: 机智的赛尔
 * @Description： 任务实体对象
 * @DateTime： 2025/4/17 13:53
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

    /** 活动ID */
    private String UserId;
    /** 消息主题 */
    private String Topic;
    /** 消息编号 */
    private String MessageId;
    /** 消息主题  */
    private BaseEvent.EventMessage<SendRebateMessageEvent.RebateMessage> message;
    /** 任务状态；create-创建、complete-完成、fail-失败 */
    private TaskStateVO state;


}
