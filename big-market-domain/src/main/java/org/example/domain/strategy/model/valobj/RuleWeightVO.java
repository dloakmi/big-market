package org.example.domain.strategy.model.valobj;

import lombok.*;

import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： 权重规则值（包装的非常丰厚） 对象
 * @DateTime： 2025/4/24 13:23
 **/
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleWeightVO {

    /** 原始规则值配置 */
    private String ruleValue;
    /** 权重值 */
    private Integer weight;
    /** 奖品配置 */
    private List<Integer> awardIds;
    /** 奖品列表 */
    private List<Award> awardList;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Award{
        private Integer awardId;
        private String awardTitle;
    }

}
