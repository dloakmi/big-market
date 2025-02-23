package org.example.test.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.strategy.model.entity.StrategyAwardEntity;
import org.example.domain.strategy.repository.IStrategyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： ****
 * @DateTime： 2025/2/22 15:34
 **/

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class queryStrategyAwardTest {

//    @Resource
//    private IStrategyRepository strategyRepository;
//    @Test
//    public void queryStrategyAward() {
//        List<StrategyAwardEntity> strategyAwardEntities = strategyRepository.queryStrategyAwardlist(100001L);
//        log.info(strategyAwardEntities.toString());
//    }
}
