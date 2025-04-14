package org.example.test.infrastructure;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.infrastructure.persistent.dao.IRaffleActivityDao;
import org.example.infrastructure.persistent.dao.IRaffleActivitySkuDao;
import org.example.infrastructure.persistent.dao.IStrategyAwardDao;
import org.example.infrastructure.persistent.po.RaffleActivity;
import org.example.infrastructure.persistent.po.RaffleActivitySku;
import org.example.infrastructure.persistent.po.StrategyAward;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖活动配置Dao测试
 * @DateTime： 2025/3/22 16:53
 **/

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleActivityDaotest {

    @Resource
    private IRaffleActivityDao raffleActivityDao;

    @Resource
    private IStrategyAwardDao strategyAwardDao;

    @Resource
    private IRaffleActivitySkuDao raffleActivitySkuDao;

    @Test
    public void test_queryRaffleActivityDao() {
//        RaffleActivity raffleActivity = raffleActivityDao.queryRaffleActivityByActivityId(100301L);
//        log.info("测试结果：{}", JSON.toJSONString(raffleActivity));

        RaffleActivitySku raffleActivitySku = raffleActivitySkuDao.queryActivitySku(9011L);
        log.info("测试结果：{}", JSON.toJSONString(raffleActivitySku));

    }

    @Test
    public void test_queryRaffleActivitySkuDao() {


        StrategyAward strategyAwardReq = new StrategyAward();
        strategyAwardReq.setStrategyId(100006L);
        strategyAwardReq.setAwardId(103);
        StrategyAward strategyAwardRes = strategyAwardDao.queryStrategyAward(strategyAwardReq);
        log.info(strategyAwardRes.toString());

    }


}
