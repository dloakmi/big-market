package org.example.domain.activity.service;

import org.example.domain.activity.repository.IActivityRepository;
import org.springframework.stereotype.Service;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖活动服务
 * @DateTime： 2025/3/24 12:58
 **/
@Service
public class RaffleActivityService extends AbstractRaffleActivity{


    public RaffleActivityService(IActivityRepository activityRepository) {
        super(activityRepository);
    }
}
