package org.example.test.domain;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.strategy.model.valobj.StrategyAwardRuleModelVO;
import org.example.domain.strategy.repository.IStrategyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: 机智的赛尔
 * @Description： 仓储测试
 * @DateTime： 2025/3/5 13:13
 **/

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class repositoryTest {

    @Resource
    private IStrategyRepository repository;

    @Test
    public void test_strategyAwardDao() {
        StrategyAwardRuleModelVO strategyAwardRuleModelVO = repository.queryStrategyAwardRuleModelVO(100001L, 101);
        log.info(strategyAwardRuleModelVO.toString());
    }
}
