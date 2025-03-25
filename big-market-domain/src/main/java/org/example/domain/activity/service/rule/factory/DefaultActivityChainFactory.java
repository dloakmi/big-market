package org.example.domain.activity.service.rule.factory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.domain.activity.service.rule.IActionChain;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: 机智的赛尔
 * @Description： 责任链工厂
 * @DateTime： 2025/3/25 14:57
 **/

@Service
public class DefaultActivityChainFactory {

    private final IActionChain actionChain;

    public DefaultActivityChainFactory(Map<String, IActionChain> actionChainGroup) {
        actionChain = actionChainGroup.get(ActionType.activity_base_action.getCode());
        actionChain.appendNext(actionChainGroup.get(ActionType.activity_sku_stock_action.getCode()));
    }

    public IActionChain openActionChain() {
        return actionChain;
    }


    @Getter
    @AllArgsConstructor
    public enum ActionType {

        activity_base_action("activity_base_action","活动时间、状态校验"),
        activity_sku_stock_action("activity_sku_stock_action","活动sku库存")
        ;



        private final String code;
        private final String info;

    }


}
