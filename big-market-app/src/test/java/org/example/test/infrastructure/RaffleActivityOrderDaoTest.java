package org.example.test.infrastructure;

import cn.bugstack.middleware.db.router.strategy.IDBRouterStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.example.domain.award.model.valobj.AccountStatusVO;
import org.example.infrastructure.persistent.dao.IRaffleActivityOrderDao;
import org.example.infrastructure.persistent.dao.IUserCreditAccountDao;
import org.example.infrastructure.persistent.po.RaffleActivityOrder;
import org.example.infrastructure.persistent.po.UserCreditAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
    private IDBRouterStrategy dbRouter;

    @Resource
    private IRaffleActivityOrderDao raffleActivityOrderDao;

    @Resource
    private IUserCreditAccountDao userCreditAccountDao;

    @Test
    public void test_userCreditAccountDao() {
        UserCreditAccount userCreditAccountReq = new UserCreditAccount();
        userCreditAccountReq.setUserId("user001");
        userCreditAccountReq.setTotalAmount(BigDecimal.valueOf(0.79));
        userCreditAccountReq.setAvailableAmount(BigDecimal.valueOf(0.79));
        userCreditAccountReq.setAccountStatus(AccountStatusVO.open.getCode());
        try {
            dbRouter.doRouter("user001");
            int updateAccountCount = userCreditAccountDao.updateAddAmount(userCreditAccountReq);
        }finally {
            dbRouter.clear();
        }
    }


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
