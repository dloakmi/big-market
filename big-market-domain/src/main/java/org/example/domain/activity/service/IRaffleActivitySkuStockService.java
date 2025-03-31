package org.example.domain.activity.service;

import org.example.domain.activity.model.valobj.ActivitySkuStockKeyVO;

/**
 * @Author: 机智的赛尔
 * @Description： 活动sku库存处理接口
 * @DateTime： 2025/3/27 17:16
 **/

public interface IRaffleActivitySkuStockService {

    /**
     * @description: 获取活动sku库存消耗队列
     * @author: 超级机智的赛尔
     * @date: 2025/3/27 17:17
     * @throws InterruptedException 异常
     * @Return: sku库存消耗队列
     **/
    ActivitySkuStockKeyVO takeQueueValue() throws InterruptedException;


    /**
     * @description: 清空队列
     * @author: 超级机智的赛尔
     * @date: 2025/3/27 17:19
     * @Return: void
     **/
    void clearQueueValue();


    /**
     * @description: 延迟队列 + 任务趋势更新活动sku库存呢
     * @author: 超级机智的赛尔
     * @date: 2025/3/27 17:20
     * @param sku 活动商品
     * @Return: void
     **/
    void updateActivitySkuStock(Long sku);


    /**
     * @description: 缓存库存已消耗完毕，清空数据库库存
     * @author: 超级机智的赛尔
     * @date: 2025/3/27 17:21
     * @param sku 活动商品
     * @Return: void
     **/
    void clearActivitySkuStock(Long sku);

}
