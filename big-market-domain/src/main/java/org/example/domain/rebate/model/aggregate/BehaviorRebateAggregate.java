package org.example.domain.rebate.model.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.rebate.model.entity.BehaviorRebateOrderEntity;
import org.example.domain.rebate.model.entity.TaskEntity;

/**
 * @Author: 机智的赛尔
 * @Description： 行为返利聚合对象
 * @DateTime： 2025/4/17 13:50
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BehaviorRebateAggregate {

    private String userId;

    private BehaviorRebateOrderEntity behaviorRebateOrder;

    private TaskEntity taskEntity;

}
