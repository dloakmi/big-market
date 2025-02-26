package org.example.domain.strategy.service.rule.chain;

/**
 * @Author: 机智的赛尔
 * @Description： 抽象责任链接口
 * @DateTime： 2025/2/26 19:44
 **/

public abstract class AbstractLogicChain implements ILogicChain{

    private ILogicChain next;


    @Override
    public ILogicChain appendNext(ILogicChain next) {
        this.next = next;
        return null;
    }

    @Override
    public ILogicChain next() {
        return next;
    }

    protected abstract String ruleModel();

}
