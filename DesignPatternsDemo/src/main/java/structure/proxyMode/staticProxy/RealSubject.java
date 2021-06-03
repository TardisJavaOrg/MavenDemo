package structure.proxyMode.staticProxy;

/**
 * 真实主题
 */
public class RealSubject implements Subject {
    @Override
    public void method1() {
        System.out.println("method1");
    }
}
