package org.example.domain.strategy.model.entity;

/**
 * @author MSI
 * @date 2025/2/23 18:48
 * @description: 策略结果实体
 */



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AwardEntity {

    /** 用户ID */
    private String userId;
    /** 奖品ID */
    private Integer awardId;

}
