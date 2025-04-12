package org.example.domain.activity.service.armory;

/**
 * @Author: 机智的赛尔
 * @Description： 活动装配预热
 * @DateTime： 2025/3/26 17:28
 **/

public interface IActivityArmory {

    boolean assembleActivitySkuByActivityId(Long activityId);

    boolean assembleActivitySku(Long sku);

}
