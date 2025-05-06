package org.example.domain.credit.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: 机智的赛尔
 * @Description： 积分账户实体
 * @DateTime： 2025/5/6 16:01
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditAccountEntity {

    /** 用户ID */
    private String userId;

    /** 可用积分，每次扣减的值 */
    private BigDecimal adjustAmount;
}
