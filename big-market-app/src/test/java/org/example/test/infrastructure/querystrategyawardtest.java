package org.example.test.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.strategy.model.valobj.RuleTreeVO;
import org.example.domain.strategy.repository.IStrategyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: 机智的赛尔
 * @Description： 仓储数据查询
 * @DateTime： 2025/2/22 15:34
 **/

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class querystrategyawardtest {

    @Resource
    private IStrategyRepository repository;

    @Test
    public void queryRuleTreeVOByTree_test() {
        RuleTreeVO ruleTreeVO = repository.queryRuleTreeVOByTreeId("tree_lock");
        log.info(ruleTreeVO.toString());

    }


}
