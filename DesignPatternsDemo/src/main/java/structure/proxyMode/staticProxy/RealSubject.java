package structure.proxyMode.staticProxy;

public class RealSubject implements Subject {
    @Override
    public void method1() {
        System.out.println("method1");
    }
}
