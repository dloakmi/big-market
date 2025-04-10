package org.example.infrastructure.persistent.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.Task;

import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： 任务表，发送MQ
 * @DateTime： 2025/3/28 17:58
 **/

@Mapper
public interface ITaskDao {

    void insert(Task task);

    void updateTaskSendMessageCompleted(Task task);

    void updateTaskSendMessageFail(Task task);

    List<Task> queryNoSendMessageTaskList();
}
