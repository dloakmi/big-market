package org.example.domain.rebate.service;

import org.example.domain.rebate.model.entity.BehaviorEntity;

import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： 行为返利服务接口
 * @DateTime： 2025/4/17 13:32
 **/

public interface IBehaviorRebateService {

    List<String> createOrder(BehaviorEntity behaviorEntity);

}
