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

    /**
     * @description: 查询还没有发送mq的task任务集合
     * @author: 超级机智的赛尔
     * @date: 2025/4/17 10:52
     * @Return: 任务集合
     **/
    public List<TaskEntity> queryNoSendMessageTaskList();

    /**
     * @description: 将任务实体当mq消息发送出去
     * @author: 超级机智的赛尔
     * @date: 2025/4/17 10:54
     * @param taskEntity 任务实体
     * @Return: void
     **/
    public void sendMessage(TaskEntity taskEntity);

    /**
     * @description: 更新Task表，更新为成功
     * @author: 超级机智的赛尔
     * @date: 2025/4/17 10:55
     * @param userId 用户ID
     * @param messageId 消息ID
     * @Return: void
     **/
    public void updateTaskSendMessageCompleted(String userId, String messageId);

    /**
     * @description: 更新Task表，更新为失败
     * @author: 超级机智的赛尔
     * @date: 2025/4/17 10:56
     * @param userId 用户ID
     * @param messageId 消息ID
     * @Return: void
     **/
    public void updateTaskSendMessageFail(String userId, String messageId);
}
