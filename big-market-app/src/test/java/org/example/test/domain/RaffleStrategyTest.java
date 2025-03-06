package org.example.test.domain;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.strategy.model.entity.RaffleAwardEntity;
import org.example.domain.strategy.model.entity.RaffleFactorEntity;
import org.example.domain.strategy.service.IRaffleStrategy;
import org.example.domain.strategy.service.armory.IStrategyArmory;

import org.example.domain.strategy.service.rule.chain.impl.RuleWeightLogicChain;
import org.example.domain.strategy.service.rule.tree.impl.RuleLockLogicTreeNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: 机智的赛尔
 * @Description： ****
 * @DateTime： 2025/2/25 19:08
 **/

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleStrategyTest {

    @Resource
    private IRaffleStrategy raffleStrategy;

    @Resource
    private IStrategyArmory strategyArmory;

    @Resource
    private RuleLockLogicTreeNode ruleLockLogicTreeNode;

    @Resource
    private RuleWeightLogicChain ruleWeightLogicChain;

    @Before
    public void setUp() {

       // strategyArmory.assembleLotteryStrategy(100001L);
       // strategyArmory.assembleLotteryStrategy(100002L);
       // strategyArmory.assembleLotteryStrategy(100003L);
        strategyArmory.assembleLotteryStrategy(100006L);

        //通过mock反射抽奖次数
        ReflectionTestUtils.setField(ruleLockLogicTreeNode,"userRaffleCount",10L);
        //通过mock反射积分
        ReflectionTestUtils.setField(ruleWeightLogicChain,"userScore",4900L);

    }

    @Test
    public void test_performRaffle() throws InterruptedException {
        // 抽奖3次
        for(int i=0; i<3 ;i++){
            RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                    .userId("xiaofuge")
                    .strategyId(100006L)
                    .build();

            RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);

            log.info("请求参数：{}", JSON.toJSONString(raffleFactorEntity));
            log.info("测试结果：{}", JSON.toJSONString(raffleAwardEntity));
        }

        new CountDownLatch(1).await();
    }

    @Test
    public void test_performRaffle_blacklist() {
        RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                .userId("user003")  // 黑名单用户 user001,user002,user003
                .strategyId(100001L)
                .build();

        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);

        log.info("请求参数：{}", JSON.toJSONString(raffleFactorEntity));
        log.info("测试结果：{}", JSON.toJSONString(raffleAwardEntity));
    }

    @Test
    public void test_performRaffle_centerRuleLock() {
        RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                .userId("xiaofuge")
                .strategyId(100001L)
                .build();

        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);

        log.info("请求参数：{}", JSON.toJSONString(raffleFactorEntity));
        log.info("测试结果：{}", JSON.toJSONString(raffleAwardEntity));
    }

}

