package structure.adapterMode.classAdapter;

/**
 * @author timothy
 * @data 2021年05月21日 4:44 下午
 * 类适配器
 * 让2个不能兼容的方法能够继承，这里 otherClass 的方法可以通过 Target 进行调用
 */
public class Main {
    public static void main(String[] args) {
        Target target = new ClassAdapter();
        // 调用request 实际上是调用了 otherClass 的方法
        target.request();
    }
}
