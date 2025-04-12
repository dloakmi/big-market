package org.example.trigger.http;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.activity.service.armory.IActivityArmory;
import org.example.domain.strategy.service.armory.IStrategyArmory;
import org.example.trigger.api.IRaffleActivityService;
import org.example.trigger.api.dto.ActivityDrawRequestDTO;
import org.example.trigger.api.dto.ActivityDrawResponseDTO;
import org.example.types.model.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖活动服务
 * @DateTime： 2025/4/12 17:03
 **/

@Slf4j
@RestController()
@CrossOrigin("${app.config.cross-origin}")
@RequestMapping("/api/${app.config.api-version}/raffle/activity")
public class RaffleActivityController implements IRaffleActivityService {

    @Resource
    private IActivityArmory activityArmory;

    @Resource
    private IStrategyArmory strategyArmory;

    @Override
    public Response<Boolean> armory(@RequestParam Long activityId) {
        try {
            log.info("活动装配，数据预热 activityId: {}", activityId);
            // 1，活动装配
            activityArmory.assembleActivitySkuByActivityId(activityId);
            // 2. 策略装配
            strategyArmory.assembleLotteryStrategyByActivityId(activityId);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    @Override
    public Response<ActivityDrawResponseDTO> draw(ActivityDrawRequestDTO request) {
        return null;
    }
}
