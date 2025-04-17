package org.example.domain.rebate.model.entity;

import lombok.Data;
import org.example.domain.rebate.model.valobj.BehaviorTypeVO;

/**
 * @Author: 机智的赛尔
 * @Description： 行为实体
 * @DateTime： 2025/4/17 13:33
 **/

@Data
public class BehaviorEntity {

    /** 用户ID */
    private String userId;

    /** 行为类型 */
    private BehaviorTypeVO behaviorType;

    /** 唯一值，幂等 */
    private String outBusinessNo;

}
