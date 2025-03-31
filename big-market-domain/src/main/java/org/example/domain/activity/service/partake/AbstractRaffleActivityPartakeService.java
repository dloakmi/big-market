package org.example.domain.activity.service.partake;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.activity.model.aggregate.CreatePartakeOrderAggregate;
import org.example.domain.activity.model.entity.ActivityEntity;
import org.example.domain.activity.model.entity.PartakeRaffleActivityEntity;
import org.example.domain.activity.model.entity.UserRaffleOrderEntity;
import org.example.domain.activity.model.valobj.ActivityStateVO;
import org.example.domain.activity.repository.IActivityRepository;
import org.example.domain.activity.service.IRaffleActivityPartakeService;
import org.example.types.enums.ResponseCode;
import org.example.types.exception.AppException;

import java.util.Date;

/**
 * @Author: 机智的赛尔
 * @Description： 抽奖活动参与抽奖类
 * @DateTime： 2025/3/31 12:30
 **/

@Slf4j
public abstract class AbstractRaffleActivityPartakeService implements IRaffleActivityPartakeService {

    protected IActivityRepository activityRepository;

    public AbstractRaffleActivityPartakeService(IActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public UserRaffleOrderEntity createOrder(PartakeRaffleActivityEntity partakeRaffleActivityEntity) {
        // 0.基础信息
        String userId = partakeRaffleActivityEntity.getUserId();
        Long activityId = partakeRaffleActivityEntity.getActivityId();
        Date currentDate = new Date();

        // 1.活动查询
        ActivityEntity activityEntity = activityRepository.queryRaffleActivityByActivityId(activityId);

        // 校验活动状态
        if(!ActivityStateVO.open.equals(activityEntity.getState())) {
            throw new AppException(ResponseCode.ACTIVITY_STATE_ERROR.getCode(),ResponseCode.ACTIVITY_STATE_ERROR.getInfo());
        }

        // 校验活动日期【开始时间<- 当前时间 ->结束时间】
        if(activityEntity.getBeginDateTime().after(currentDate) || activityEntity.getEndDateTime().before(currentDate)) {
            throw new AppException(ResponseCode.ACTIVITY_DATE_ERROR.getCode(),ResponseCode.ACTIVITY_DATE_ERROR.getInfo());
        }

        UserRaffleOrderEntity userRaffleOrderEntity = activityRepository.queryNoUsedRaffleOrder(partakeRaffleActivityEntity);
        if(userRaffleOrderEntity != null) {
            log.info("创建参与活动订单 userID:{}, activityID:{}, userRaffleOrderEntity:{}", userId, activityId, JSON.toJSONString(userRaffleOrderEntity));
            return userRaffleOrderEntity;
        }

        // 3.额度账户过滤&返回账户构建对象
        CreatePartakeOrderAggregate createPartakeOrderAggregate = this.doFilterAccount(userId, activityId, currentDate);

        // 4.构建订单
        UserRaffleOrderEntity userRaffleOrder = this.buildUserRaffleOrder(userId, activityId, currentDate);

        // 5.填充抽奖单实体对象
        createPartakeOrderAggregate.setUserRaffleOrderEntity(userRaffleOrder);

        // 6.保存聚合对象 - 一个领域内的一个聚合是一个事务操作
        activityRepository.saveCreatePartakeOrderAggregate(createPartakeOrderAggregate);

        // 7.返回订单消息
        return userRaffleOrder;
    }

    protected abstract UserRaffleOrderEntity buildUserRaffleOrder(String userId, Long activityId, Date currentDate);

    protected abstract CreatePartakeOrderAggregate doFilterAccount(String userId, Long activityId, Date currentDate);
}
