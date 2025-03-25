package org.example.domain.activity.model.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.activity.model.entity.ActivityAccountEntity;
import org.example.domain.activity.model.entity.ActivityOrderEntity;

/**
 * @Author: 机智的赛尔
 * @Description： 下单聚合对象
 * @DateTime： 2025/3/24 11:03
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderAggregate {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 总次数
     */
    private Integer totalCount;

    /**
     * 日次数
     */
    private Integer dayCount;

    /**
     * 月次数
     */
    private Integer monthCount;


    /**
     * 活动订单实体
     **/
    private ActivityOrderEntity activityOrderEntity;

}
