package org.example.infrastructure.persistent.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.RaffleActivitySku;

/**
 * @Author: 机智的赛尔
 * @Description： 商品sku dao
 * @DateTime： 2025/3/24 10:19
 **/

@Mapper
public interface IRaffleActivitySkuDao {

    RaffleActivitySku queryActivitySku(Long sku);
}
