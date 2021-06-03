package structure.proxyMode.dynamicProxy;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author timothy
 * @data 2021年05月28日 5:46 下午
 * JDK的动态代理
 */
public class JdkFuDao implements InvocationHandler {

    private Person target;

    public Person getInstance(Person target) {
        this.target = target;
        Class<? extends Person> cls = target.getClass();
        // 这里实际上返回了 Person 的一个子类
        return (Person) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.target, args);
        after();
        return result;
    }

    public void after() {
        System.out.println("after");
    }

    public void before() {
        System.out.println("before");
    }
}
