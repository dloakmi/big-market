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
            dbRouter.setDBKey(1);
            dbRouter.setTBKey(0);
            List<TaskEntity> taskEntities = taskService.queryNoSendMessageTaskList();
            log.info("测试结果：{}", taskEntities.size());

        } catch (Exception e){
            log.error("定时任务发送失败",e);
        }finally {
            dbRouter.clear();
        }


    }

}
