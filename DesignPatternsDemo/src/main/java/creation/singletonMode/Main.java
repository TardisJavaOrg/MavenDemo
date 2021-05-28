package creation.singletonMode;

/**
 * @author timothy
 * @data 2021年05月28日 3:48 下午
 */
public class Main {
    public static void main(String[] args) {
        LazySingleton instance1 = LazySingleton.getInstance1();
        LazySingleton instance2 = LazySingleton.getInstance2();
        System.out.println(instance1 == instance2);
    }
}
