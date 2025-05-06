package org.example.domain.credit.repository;

import org.example.domain.credit.model.aggregate.TradeAggregate;

/**
 * @Author: 机智的赛尔
 * @Description： 积分仓储接口
 * @DateTime： 2025/5/6 15:50
 **/

public interface ICreditRepository {

    void saveUserCreditTradeOrder(TradeAggregate tradeAggregate);
}
