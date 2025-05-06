package org.example.infrastructure.persistent.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.UserCreditAccount;

/**
 * @Author: 机智的赛尔
 * @Description： 用户积分账户
 * @DateTime： 2025/4/28 14:35
 **/

@Mapper
public interface IUserCreditAccountDao {


    int updateAddAmount(UserCreditAccount userCreditAccountReq);

    void insert(UserCreditAccount userCreditAccountReq);

    UserCreditAccount queryUserCreditAccount(UserCreditAccount userCreditAccountReq);
}
