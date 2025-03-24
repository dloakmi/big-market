package org.example.test.infrastructure;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.infrastructure.persistent.dao.IAwardDao;
import org.example.infrastructure.persistent.dao.IStrategyAwardDao;
import org.example.infrastructure.persistent.po.StrategyAward;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： 测试持久层
 * @DateTime： 2025/2/21 14:27
 **/

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AwardDaoTest {

    @Resource
    private IAwardDao awardDao;

    @Resource
    private IStrategyAwardDao strategyAwardDao;

    @Test
    public void test_AwardDao() {
//        List<Award> ls = awardDao.queryAwardList();
//        log.info("测试结果:{}", JSON.toJSONString(ls));
        List<StrategyAward> strategyAwards = strategyAwardDao.queryStrategyAwardListByStrategyId(100001L);
        log.info(JSON.toJSONString(strategyAwards));
    }


}
