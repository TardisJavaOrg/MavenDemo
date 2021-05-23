package structure.adapterMode.objectAdapter;

/**
 * @author timothy
 * @data 2021年05月21日 4:44 下午
 * 对象适配器
 */
public class Main {
    public static void main(String[] args) {
        Target target = new ObjectAdapter(new OtherClass());
        // 调用request 实际上是调用了 otherClass 的方法
        target.request();
    }
}
