package org.example.domain.strategy.service.armory;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.strategy.model.entity.StrategyAwardEntity;
import org.example.domain.strategy.repository.IStrategyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.*;

/**
 * @Author: 机智的赛尔
 * @Description： 策略、概率 装配库（兵工厂），负责初始化策略计算
 * @DateTime： 2025/2/21 19:25
 **/

@Slf4j
@Service
public class StrategyArmory implements IStrategyArmory {
    @Resource
    private IStrategyRepository repository;


    @Override
    public void assembleLotteryStrategy(Long strategyId) {

        //1.查询策略配置
        List<StrategyAwardEntity> strategyAwardEntities = repository.queryStrategyAwardlist(strategyId);

        //2.获取最小值概率
        BigDecimal minAwardRate = strategyAwardEntities.stream()
                .map(StrategyAwardEntity::getAwardRate)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        //3.获取概率值相加总和
        BigDecimal totalAwardRate = strategyAwardEntities.stream()
                .map(StrategyAwardEntity::getAwardRate)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        //4.用概率综合除以最小概率值来获取概率范围
        BigDecimal rateRange = totalAwardRate.divide(minAwardRate, 0, RoundingMode.CEILING);

        //5.根据概率分布分配list中的位置
        ArrayList<Integer> strategyAwardSearchRateTables = new ArrayList<>(rateRange.intValue());
        for(StrategyAwardEntity strategyAwardEntity : strategyAwardEntities) {
            Integer awardId = strategyAwardEntity.getAwardId();
            BigDecimal awardRate = strategyAwardEntity.getAwardRate();
            //计算每个概率值所需要的在查找表中的位置数量
            for(int i=0;i<rateRange.multiply(awardRate).setScale(0, RoundingMode.CEILING).intValue() ;i++){
                strategyAwardSearchRateTables.add(awardId);
            }
        }

        //6.乱序
        Collections.shuffle(strategyAwardSearchRateTables);

        //7.建立哈希表
        HashMap<Integer,Integer> shuffledStrategyAwardSearchRateTable = new LinkedHashMap<>();
        for(int i=0;i<strategyAwardSearchRateTables.size();i++){
            shuffledStrategyAwardSearchRateTable.put(i,strategyAwardSearchRateTables.get(i));
        }

        //8.存储到redis中
        repository.storeStrategyAwardSearchRateTables(strategyId,shuffledStrategyAwardSearchRateTable.size(),shuffledStrategyAwardSearchRateTable);

    }

    @Override
    public Integer getRandomAwardId(long strategyId) {
        int rateRange = repository.getRateRange(strategyId);
        return repository.getStrategyAwardAssemble(strategyId, new SecureRandom().nextInt(rateRange));
    }

}
