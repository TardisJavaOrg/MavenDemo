package action.strategy;

/**
 * @author timothy
 * @data 2021年05月28日 1:52 下午
 * 策略模式
 * 根据策略到不同执行不同的 策略方法
 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        Strategy strategyA = new ConcreteStrategyA();
        context.setStrategy(strategyA);
        context.strategyMethod();
        System.out.println("==========");
        Strategy strategyB = new ConcreteStrategyB();
        context.setStrategy(strategyB);
        context.strategyMethod();
    }
}
