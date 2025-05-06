package org.example.domain.credit.service;

import org.example.domain.credit.model.entity.TradeEntity;

/**
 * @Author: 机智的赛尔
 * @Description： 积分调额接口
 * @DateTime： 2025/5/6 15:52
 **/

public interface ICreditAdjustService {


    /**
     * @description: 创建增加积分额度订单
     * @author: 超级机智的赛尔
     * @date: 2025/5/6 16:58
     * @param tradeEntity 交易实体对象
     * @Return: 单号
     **/
    String createOrder(TradeEntity tradeEntity);

}
