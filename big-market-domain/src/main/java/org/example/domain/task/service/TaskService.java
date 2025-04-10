package org.example.domain.task.service;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.example.domain.task.model.entity.TaskEntity;
import org.example.domain.task.repository.ITaskRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： 消息任务服务
 * @DateTime： 2025/4/10 16:59
 **/

@Service
public class TaskService implements ITaskService {

    @Resource
    private ITaskRepository taskRepository;

    @Override
    public List<TaskEntity> queryNoSendMessageTaskList() {
        return taskRepository.queryNoSendMessageTaskList();
    }

    @Override
    public void sendMessage(TaskEntity taskEntity) {
        taskRepository.sendMessage(taskEntity);
    }

    @Override
    public void updateTaskSendMessageCompleted(String userId, String MessageId) {
        taskRepository.updateTaskSendMessageCompleted(userId, MessageId);
    }

    @Override
    public void updateTaskSendMessageFail(String userId, String MessageId) {
        taskRepository.updateTaskSendMessageFail(userId, MessageId);
    }
}
