package org.example.domain.task.service;



import org.example.domain.task.model.entity.TaskEntity;

import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： 消息任务服务接口
 * @DateTime： 2025/4/10 10:26
 **/

public interface ITaskService {

    List<TaskEntity> queryNoSendMessageTaskList();

    void sendMessage(TaskEntity taskEntity);

    void updateTaskSendMessageCompleted(String userId , String MessageId);

    void updateTaskSendMessageFail(String userId , String MessageId);

}
