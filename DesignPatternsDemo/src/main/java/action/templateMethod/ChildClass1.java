package action.templateMethod;

/**
 * @author timothy
 * @data 2021年05月28日 2:27 下午
 */
public class ChildClass1 extends AbstractClass {
    @Override
    void abstractMethod1() {
        System.out.println("方法 1");
    }

    @Override
    void abstractMethod2() {
        System.out.println("方法  2");
    }
}
