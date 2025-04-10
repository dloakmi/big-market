package org.example.test.domain.award;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.award.service.IAwardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: 机智的赛尔
 * @Description： 奖品服务测试
 * @DateTime： 2025/4/10 17:35
 **/

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AwardServiceTest {

    private IAwardService awardService;

    @Test
    public void test_saveUserAwardRecord() throws InterruptedException {

        new CountDownLatch(1).await();
    }

}
