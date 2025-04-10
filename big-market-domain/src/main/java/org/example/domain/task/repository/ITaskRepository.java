package org.example.domain.task.repository;

import org.example.domain.task.model.entity.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： 任务服务仓储
 * @DateTime： 2025/4/10 16:56
 **/

@Repository
public interface ITaskRepository {


    public List<TaskEntity> queryNoSendMessageTaskList();

    public void sendMessage(TaskEntity taskEntity);

    public void updateTaskSendMessageCompleted(String userId, String messageId);

    public void updateTaskSendMessageFail(String userId, String messageId);
}
