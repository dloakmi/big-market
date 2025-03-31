package org.example.domain.activity.service.quota.rule;

import org.example.domain.activity.model.entity.ActivityCountEntity;
import org.example.domain.activity.model.entity.ActivityEntity;
import org.example.domain.activity.model.entity.ActivitySkuEntity;

/**
 * @Author: 机智的赛尔
 * @Description： 下单规则过滤接口
 * @DateTime： 2025/3/24 17:16
 **/

public interface IActionChain extends IActionChainArmory{

    boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity);

}
