package org.example.trigger.job;

import cn.bugstack.middleware.db.router.strategy.IDBRouterStrategy;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.task.model.entity.TaskEntity;
import org.example.domain.task.service.ITaskService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: 机智的赛尔
 * @Description： 发送MQ消息任务队列
 * @DateTime： 2025/4/10 10:23
 **/

@Slf4j
@Component
public class SendMessageTaskJob {


    @Resource
    private ITaskService taskService;

    @Resource
    private ThreadPoolExecutor executor;

    @Resource
    private IDBRouterStrategy dbRouter;


    @Scheduled(cron = "0/5 * * * * ?")
    public void exec(){

        try{
            // 获取分库数量
            int dbCount = dbRouter.dbCount();
            for(int dbIndex=1; dbIndex<dbCount; dbIndex++){
                int finalDbIndex = dbIndex;
                executor.execute(()-> {
                    try {
                        dbRouter.setDBKey(finalDbIndex);
                        dbRouter.setTBKey(0);
                        List<TaskEntity> taskEntities = taskService.queryNoSendMessageTaskList();

                        // 发送MQ消息
                        for(TaskEntity taskEntity : taskEntities){
                            // 开启线程发送，提高发送效率。配置的线程池策略为 callerRunPolicy， 在ThreadPoolConfig 配置中有四个策略，面试中容易对比提问。可以检索下相关资料
                            executor.execute(() ->{
                                try{
                                    taskService.sendMessage(taskEntity);
                                    taskService.updateTaskSendMessageCompleted(taskEntity.getUserId(),taskEntity.getMessageId());
                                } catch (Exception e) {
                                    log.error("定时任务，发送MQ消息失败 userId：{} topic:{}", taskEntity.getUserId(), taskEntity.getTopic());
                                    taskService.updateTaskSendMessageFail(taskEntity.getUserId(),taskEntity.getMessageId());
                                }
                            });
                        }
                    }finally {
                        dbRouter.clear();
                    }
                });
            }
        } catch (Exception e){
            log.error("定时任务失败，扫描MQ任务表发送失败",e);
        }


    }

}
