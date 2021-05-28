package action.state;

/**
 * @author timothy
 * @data 2021年05月26日 8:13 下午
 */
public class ConcreteStateB extends State {
    @Override
    public void Handle(Context context) {
        System.out.println("当前状态B");
        context.setState(new ConcreteStateA());
    }
}
