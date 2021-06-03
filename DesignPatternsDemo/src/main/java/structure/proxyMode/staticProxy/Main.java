package structure.proxyMode.staticProxy;

/**
 * @author timothy
 * @data 2021年05月21日 8:42 下午
 * 静态代理模式
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new SubjectProxy();
        subject.method1();
    }
}
