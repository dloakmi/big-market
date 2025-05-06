package org.example.domain.credit.model.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.domain.credit.model.entity.CreditAccountEntity;
import org.example.domain.credit.model.entity.CreditOrderEntity;
import org.example.domain.credit.model.valobj.TradeNameVO;
import org.example.domain.credit.model.valobj.TradeTypeVO;

import java.math.BigDecimal;

/**
 * @Author: 机智的赛尔
 * @Description： 交易聚合对象
 * @DateTime： 2025/5/6 16:05
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradeAggregate {

    /** 用户ID */
    private String userId;

    /** 积分账户实体 */
    private CreditAccountEntity creditAccountEntity;

    /** 积分订单实体 */
    private CreditOrderEntity creditOrderEntity;


    public static CreditAccountEntity createCreditAccountEntity(String userId , BigDecimal adjustAmount) {
        return CreditAccountEntity.builder().userId(userId).adjustAmount(adjustAmount).build();
    }

    public static CreditOrderEntity createCreditOrderEntity(String userId ,
                                                            TradeNameVO tradeNameVO,
                                                            TradeTypeVO tradeTypeVO,
                                                            BigDecimal adjustAmount,
                                                            String outBusinessNo) {
        return CreditOrderEntity.builder()
                .userId(userId)
                .orderId(RandomStringUtils.randomNumeric(12))
                .tradeName(tradeNameVO)
                .tradeType(tradeTypeVO)
                .tradeAmount(adjustAmount)
                .outBusinessNo(outBusinessNo)
                .build();

    }
}
