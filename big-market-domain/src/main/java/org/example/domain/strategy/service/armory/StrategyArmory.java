package org.example.domain.strategy.service.armory;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.strategy.model.entity.StrategyAwardEntity;
import org.example.domain.strategy.repository.IStrategyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： 策略装配库（兵工厂），负责初始化策略计算
 * @DateTime： 2025/2/21 19:25
 **/

@Slf4j
@Service
public class StrategyArmory implements IStrategyArmory {

    @Resource
    private IStrategyRepository repository;


    @Override
    public void assembleLotteryStrategy(Long strategyId) {

        //1.查询策略配置
        List<StrategyAwardEntity> strategyAwardEntities = repository.queryStrategyAwardlist(strategyId);

    }
}
