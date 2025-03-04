package org.example.infrastructure.persistent.dao;


import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.RuleTreeNodeLine;

import java.util.List;

/**
 * @Author: 机智的赛尔
 * @Description： 规则树节点连线表DAO
 * @DateTime： 2025/3/4 14:38
 **/
@Mapper
public interface IRuleTreeNodeLineDao {

    List<RuleTreeNodeLine> queryRuleTreeNodeLineListByTreeId(String treeId);

}
