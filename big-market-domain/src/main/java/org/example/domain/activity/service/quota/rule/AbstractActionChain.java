package org.example.domain.activity.service.quota.rule;

/**
 * @Author: 机智的赛尔
 * @Description： 下单规则责任链抽象类
 * @DateTime： 2025/3/25 14:43
 **/

public abstract class AbstractActionChain implements IActionChain {

    private IActionChain next;

    @Override
    public IActionChain next() {
        return next;
    }

    @Override
    public IActionChain appendNext(IActionChain next) {
        this.next = next;
        return this;
    }
}
