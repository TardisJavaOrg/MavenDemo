package action.strategy;

/**
 * @author timothy
 * @data 2021年05月28日 1:52 下午
 */
public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        if (strategy != null) {
            strategy.method();
        }else{
            System.out.println("strategy can`t` be null");
        }
    }
}
