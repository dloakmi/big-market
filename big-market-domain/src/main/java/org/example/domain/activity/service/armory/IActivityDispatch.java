package org.example.domain.activity.service.armory;

import java.util.Date;

/**
 * @Author: 机智的赛尔
 * @Description： 活动调度【扣减库存】
 * @DateTime： 2025/3/26 17:58
 **/

public interface IActivityDispatch {

    
    /**
     * @description: 根据策略ID和奖品ID，扣减奖品缓存库存
     * @author: 超级机智的赛尔
     * @date: 2025/3/27 10:03
     * @param sku 活动sku
     * @param endDateTime 活动结束时间，根据结束时间设置加锁的key为结束时间
     * @Return: 扣减结果
     **/
    boolean subtractionActivitySkuStock(Long sku, Date endDateTime);

}
