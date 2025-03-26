package org.example.domain.activity.service.armory;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.activity.model.entity.ActivitySkuEntity;
import org.example.domain.activity.repository.IActivityRepository;
import org.example.types.common.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: 机智的赛尔
 * @Description： 活动sku预热
 * @DateTime： 2025/3/26 17:31
 **/

@Slf4j
@Service
public class ActivityArmory implements IActivityArmory {

    @Resource
    private IActivityRepository activityRepository;

    @Override
    public boolean assembleActivitySku(Long sku) {
        ActivitySkuEntity activitySkuEntity = activityRepository.queryActivitySku(sku);
        cacheActivitySkuStockCount(sku,activitySkuEntity.getStockCount());

        // 预热活动 【查询时预热到缓存】
        activityRepository.queryRaffleActivityByActivityId(activitySkuEntity.getActivityId());
        // 预热活动次数 【查询时预热到缓存】
        activityRepository.queryRaffleActivityCountByActivityCountId(activitySkuEntity.getActivityCountId());
        return false;
    }

    private void cacheActivitySkuStockCount(Long sku, Integer stockCount) {
        String cacheKey = Constants.RedisKey.ACTIVITY_SKU_STOCK_COUNT_KEY + sku;
        activityRepository.cacheActivitySkuStockCount(cacheKey,stockCount);

    }
}
