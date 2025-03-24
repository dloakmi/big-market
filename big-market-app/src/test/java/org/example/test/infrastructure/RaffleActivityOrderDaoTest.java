package org.example.test.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.example.infrastructure.persistent.dao.IRaffleActivityOrderDao;
import org.example.infrastructure.persistent.po.RaffleActivityOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖活动订单测试
 * @DateTime： 2025/3/22 17:06
 **/

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleActivityOrderDaoTest {

    @Resource
    private IRaffleActivityOrderDao raffleActivityOrderDao;

    @Test
    public void test_insert(){
        RaffleActivityOrder raffleActivityOrder = new RaffleActivityOrder();
        raffleActivityOrder.setActivityId(100301L);
        raffleActivityOrder.setUserId("wangshengliang");
        raffleActivityOrder.setActivityName("测试活动");
        raffleActivityOrder.setStrategyId(100006L);
        raffleActivityOrder.setOrderId(RandomStringUtils.randomNumeric(12));
        raffleActivityOrder.setOrderTime(new Date());
        raffleActivityOrder.setState("not_used");

        raffleActivityOrderDao.insert(raffleActivityOrder);

    }


}
