package org.example.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： 规则树节点对象
 * @DateTime： 2025/3/3 20:54
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleTreeNodeVO {

    /** 规则树ID */
    private Integer treeId;
    /** 规则Key */
    private String ruleKey;
    /** 规则描述 */
    private String ruleDesc;
    /** 规则比值 */
    private String ruleValue;

    /** 规则连线 */
    private List<RuleTreeNodeLineVO> treeNodeLineVOList;

}

