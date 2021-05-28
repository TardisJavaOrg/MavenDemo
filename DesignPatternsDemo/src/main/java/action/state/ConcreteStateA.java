package action.state;

/**
 * @author timothy
 * @data 2021年05月26日 7:52 下午
 */
public class ConcreteStateA extends State {

    /**
     * 执行了上下文方法之后，再修改状态
     *
     * @param context
     */
    public void Handle(Context context) {
        System.out.println("当前状态是 A.");
        context.setState(new ConcreteStateB());
    }
}
