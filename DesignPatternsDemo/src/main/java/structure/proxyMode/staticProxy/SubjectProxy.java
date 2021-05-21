package structure.proxyMode.staticProxy;

/**
 * 代理模式
 * 在执行某方法前后，做一些前置操作或者限制
 * 好处：
 * 保证一个类只负责一件事情
 * 不需要修改类功能
 * 便于测试，一次只测试一个功能
 */
public class SubjectProxy implements Subject {
    private Subject subject;


    @Override
    public void method1() {
        if (subject == null) {
            subject = new RealSubject();
        }
        preMethod();
        subject.method1();
        postMethod();
    }

    private void postMethod() {
        System.out.println("post method");
    }

    private void preMethod() {
        System.out.println("pre method");
    }
}