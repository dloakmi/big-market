package org.example.trigger.api.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： ****
 * @DateTime： 2025/4/24 11:11
 **/

@Data
public class RaffleStrategyRuleWeightResponseDTO {

    private Integer ruleWeightCount;

    private Integer userActivityAccountTotalUseCount;

    private List<?> strategyAwards;

    @Data
    public static class StrategyAward {

        private Integer awardId;

        private String awardTitle;

    }


}
