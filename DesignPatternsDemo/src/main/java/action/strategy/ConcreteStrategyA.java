package action.strategy;

/**
 * @author timothy
 * @data 2021年05月28日 1:51 下午
 */
public class ConcreteStrategyA implements Strategy{
    @Override
    public void method() {
        System.out.println("strategy A.");
    }
}
