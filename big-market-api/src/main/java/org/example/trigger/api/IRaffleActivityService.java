package org.example.trigger.api;

import org.example.trigger.api.dto.ActivityDrawRequestDTO;
import org.example.trigger.api.dto.ActivityDrawResponseDTO;
import org.example.types.model.Response;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖活动服务
 * @DateTime： 2025/4/12 16:56
 **/

public interface IRaffleActivityService {

    /**
     * @description: 活动装配，数据预测缓存
     * @author: 超级机智的赛尔
     * @date: 2025/4/12 16:57
     * @param activityId 活动ID
     * @Return: 装配结果
     **/
    Response<Boolean> armory(Long activityId);

    /**
     * @description: 活动抽奖接口
     * @author: 超级机智的赛尔
     * @date: 2025/4/12 16:59
     * @param request 请求对象
     * @Return: 返回结果
     **/
    Response<ActivityDrawResponseDTO> draw(ActivityDrawRequestDTO request);

}
