package action.templateMethod;

/**
 * @author timothy
 * @data 2021年05月28日 2:19 下午
 * 模版方法模式
 * 将可变对操作步骤 延迟到子类中实现
 */
public class Main {
    public static void main(String[] args) {
        AbstractClass clzz = new ChildClass1();
        clzz.templateMethod();
    }
}
