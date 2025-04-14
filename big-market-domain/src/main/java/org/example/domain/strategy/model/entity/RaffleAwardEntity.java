package org.example.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖奖品实体
 * @DateTime： 2025/2/25 9:31
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleAwardEntity {


    /** 奖品ID */
    private Integer awardId;
    /** 奖品标题（名称） */
    private String awardTitle;
    /** 奖品配置信息 */
    private String awardConfig;
    /** 排序 **/
    private Integer sort;

}
