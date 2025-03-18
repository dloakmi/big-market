package org.example.trigger.api;

import org.example.trigger.api.dto.RaffleAwardListRequestDTO;
import org.example.trigger.api.dto.RaffleAwardListResponseDTO;
import org.example.trigger.api.dto.RaffleRequestDTO;
import org.example.trigger.api.dto.RaffleResponseDTO;
import org.example.types.model.Response;

import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖服务接口
 * @DateTime： 2025/3/13 13:10
 **/

public interface IRaffleService {
    
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
     * @description: 随机抽奖接口
     * @author: 超级机智的赛尔
     * @date: 2025/3/13 13:22
     * @param requestDTO 请求参数
     * @Return: 抽奖结果
     **/
    Response<RaffleResponseDTO> randomRaffle(RaffleRequestDTO requestDTO);



}
