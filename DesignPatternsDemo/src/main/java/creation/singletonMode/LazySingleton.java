package creation.singletonMode;

/**
 * 线程不安全的
 * 懒加载的单例模式
 * 原因：多线程下，可能同时判断出single为null，就创建了多个实例
 */
public class LazySingleton {
    private static LazySingleton single;
//    private volatile static LazySingleton single; // 懒加载需要增加volatile关键字

    /**
     * 构造方法私有化，就不能被外部创建
     */
    private LazySingleton() {
    }

    /**
     * 普通懒汉模式
     * @return
     */
    public static LazySingleton getInstance1() {
        if (single == null) single =  new LazySingleton();
        return single;
    }

    // 双重验证的懒加载模式
    // synchronized 也不能保证不会创建重复的实例
    // 这是因为，JVM会对指令进行重排
    // 创建一个对象顺序如下：
    // 1. 给single开辟内存空间
    // 2. 初始化single对象
    // 3. 将引用 single指向 这块内存地址
    // JVM会对指令进行重排，有可能是1-3-2
    // 这样第二个线程进来，发现single指向一个地址就不会认为是null直接返回single
    // 就有可能出现空指针错误
    // 所以加上 volatile，那么指令就不会被重排了。
    public static LazySingleton getInstance2() {
        if (single == null)
            synchronized (LazySingleton.class) {
                if (single == null) {
                    single = new LazySingleton();
                }
            }
        return single;
    }
}
