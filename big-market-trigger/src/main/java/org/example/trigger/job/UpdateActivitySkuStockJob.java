package org.example.trigger.job;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.activity.model.valobj.ActivitySkuStockKeyVO;
import org.example.domain.activity.service.IRaffleActivitySkuStockService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: 机智的赛尔
 * @Description： 更新活动sku库存任务
 * @DateTime： 2025/3/27 17:37
 **/

@Component
@Slf4j
public class UpdateActivitySkuStockJob {

    @Resource
    private IRaffleActivitySkuStockService skuStock;

    @Scheduled(cron = "0/5 * * * * ?")
    public void exec(){
        try {
            ActivitySkuStockKeyVO activitySkuStockKeyVO = skuStock.takeQueueValue();
            // log.info("定时任务，更新活动sku库存【延迟队列获取，降低对数据库的更新频次，不要产生竞争】");
            if(activitySkuStockKeyVO == null)return;
            log.info("定时任务，更新活动sku库存 sku:{} activityId:{}", activitySkuStockKeyVO.getSku(), activitySkuStockKeyVO.getActivityId());
            skuStock.updateActivitySkuStock(activitySkuStockKeyVO.getSku());

        }catch (Exception e){
            log.error("定时任务失败",e);
        }
    }
}
