package org.example.infrastructure.persistent.po;

import lombok.Data;

/**
 * @Author: 机智的赛尔
 * @Description： 奖品表
 * @DateTime： 2025/2/21 13:31
 **/

@Data
public class Award {

    /** 自增ID */
    private String id ;

    /** 抽奖奖品ID - 内部流转使用 */
    private String awardId;

    /** 奖品对接标识 - 每一个都是一个对应的发奖策略 */
    private String awardKey;

    /** 奖品配置信息 */
    private String awardConfig;

    /** 奖品内容描述 */
    private String awardDesc;

    /** 创建时间 */
    private String createTime;

    /** 更新时间 */
    private String updateTime;

}
