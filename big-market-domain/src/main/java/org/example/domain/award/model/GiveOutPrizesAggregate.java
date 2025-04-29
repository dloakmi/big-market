package org.example.domain.award.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.award.model.entity.UserAwardRecordEntity;
import org.example.domain.award.model.entity.UserCreditAwardEntity;
import org.example.domain.award.model.valobj.AwardStateVO;

import java.math.BigDecimal;

/**
 * @Author: 机智的赛尔
 * @Description： 发放奖品聚合对象
 * @DateTime： 2025/4/29 9:45
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GiveOutPrizesAggregate {

    /** 用户ID */
    private String userId;
    /** 用户发奖记录 */
    private UserAwardRecordEntity userAwardRecordEntity;
    /** 用户积分奖品 */
    private UserCreditAwardEntity userCreditAwardEntity;

    public static UserAwardRecordEntity buildDistributeUserAwardRecordEntity(String userId, String orderId, Integer awardId, AwardStateVO awardState) {
        UserAwardRecordEntity userAwardRecord = new UserAwardRecordEntity();
        userAwardRecord.setUserId(userId);
        userAwardRecord.setOrderId(orderId);
        userAwardRecord.setAwardId(awardId);
        userAwardRecord.setAwardState(awardState);
        return userAwardRecord;
    }

    public static UserCreditAwardEntity buildUserCreditAwardEntity(String userId, BigDecimal creditAmount) {
        return UserCreditAwardEntity.builder().userId(userId).creditAmount(creditAmount).build();
    }

}
