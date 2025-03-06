package org.example.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 机智的赛尔
 * @Description： 策略奖品库存key标识值对象
 * @DateTime： 2025/3/6 13:35
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardStockKeyVO {

    /** 策略ID */
    private Long strategyId;

    /** 奖品ID */
    private Integer awardId;

}
