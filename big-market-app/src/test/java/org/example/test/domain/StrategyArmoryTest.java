package org.example.test.domain;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.strategy.service.armory.IStrategyArmory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: 机智的赛尔
 * @Description： 装配策略奖品服务 test
 * @DateTime： 2025/2/22 15:01
 **/

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyArmoryTest {

    @Resource
    IStrategyArmory strategyArmory;

    @Test
    public void test_strategy_armory() {
        strategyArmory.assembleLotteryStrategy(100002L);

    }

    @Test
    public void test_get_random_val() {
        log.info("测试结果：{}",strategyArmory.getRandomAwardId(100002L));
        log.info("测试结果：{}",strategyArmory.getRandomAwardId(100002L));
        log.info("测试结果：{}",strategyArmory.getRandomAwardId(100002L));
    }


}
