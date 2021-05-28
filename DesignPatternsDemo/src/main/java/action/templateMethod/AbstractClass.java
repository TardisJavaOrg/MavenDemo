package action.templateMethod;

/**
 * @author timothy
 * @data 2021年05月28日 2:20 下午
 */
public abstract class AbstractClass {
    public void templateMethod() {
        specificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    abstract void abstractMethod1();

    abstract void abstractMethod2();

    public void specificMethod() {
        System.out.println("父类实现的方法 specific method");
    }
}
