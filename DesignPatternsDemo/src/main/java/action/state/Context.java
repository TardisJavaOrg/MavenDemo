package action.state;

import lombok.Data;

/**
 * @author timothy
 * @data 2021年05月26日 7:50 下午
 */
@Data
public class Context {
    private State state;

    public Context() {
        this.state = new ConcreteStateA();
    }

    /**
     * 根据不同的状态执行不同的方法
     */
    public void Handle() {
        this.state.Handle(this);
    }
}
