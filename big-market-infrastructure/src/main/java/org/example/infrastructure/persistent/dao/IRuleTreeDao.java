package org.example.infrastructure.persistent.dao;


import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.RuleTree;


/**
 * @Author: 机智的赛尔
 * @Description： 规则树表DAO
 * @DateTime： 2025/3/4 14:38
 **/
@Mapper
public interface IRuleTreeDao {

    RuleTree queryRuleTreeByTreeId(String treeId);

}
