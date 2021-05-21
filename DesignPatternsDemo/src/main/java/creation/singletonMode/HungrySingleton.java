package creation.singletonMode;

/**
 * 饿汉模式
 */
public class HungrySingleton {
    private static HungrySingleton single = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return single;
    }
}
