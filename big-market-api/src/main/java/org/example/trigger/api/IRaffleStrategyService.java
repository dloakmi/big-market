package org.example.trigger.api;

import org.example.trigger.api.dto.*;
import org.example.types.model.Response;

import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖服务接口
 * @DateTime： 2025/3/13 13:10
 **/

public interface IRaffleStrategyService {
    
    /**
     * @description: 策略装配接口
     * @author: 超级机智的赛尔
     * @date: 2025/3/13 13:21 
     * @param strategyId 策略ID
     * @Return: 装配结果
     **/
    Response<Boolean> strategyArmory(Long strategyId);
    
    /**
     * @description: 查询抽奖奖品列表配置
     * @author: 超级机智的赛尔
     * @date: 2025/3/13 13:21 
     * @param requestDTO 抽奖奖品列表查询请求参数
     * @Return: 奖品列表数据
     **/
    Response<List<RaffleAwardListResponseDTO>> queryRaffleAwardList(RaffleAwardListRequestDTO requestDTO);

    /**
     * @description: 查询抽奖策略权重规则，给用户展示出抽奖N次后必中奖奖品范围 (也可以说是分段 "限制值 " + 以及限制值下的奖品列表详细信息)
     * @author: 超级机智的赛尔
     * @date: 2025/4/24 15:33
     * @param requestDTO 请求对象
     * @Return: 权重奖品配置列表「这里会返回全部，前端可按需展示一条已达标的，或者一条要达标的」
     **/
    Response<List<RaffleStrategyRuleWeightResponseDTO>> queryRaffleStrategyRuleWeight(RaffleStrategyRuleWeightRequestDTO requestDTO);


    /**
     * @description: 随机抽奖接口
     * @author: 超级机智的赛尔
     * @date: 2025/3/13 13:22
     * @param requestDTO 请求参数
     * @Return: 抽奖结果
     **/
    Response<RaffleStrategyResponseDTO> randomRaffle(RaffleStrategyRequestDTO requestDTO);



}
