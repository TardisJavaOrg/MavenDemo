package action.state;

/**
 * @author timothy
 * @data 2021年05月28日 1:36 下午
 * 状态模式
 * 根据状态不同执行 不同方法
 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.Handle();
        context.Handle();
        context.Handle();
    }
}
