package structure.decoratorMode;

/**
 * @author timothy
 * @data 2021年05月21日 8:40 下午
 */
public class Main {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operation();
        // 下面为装饰器执行
        Decorator decorator = new ConcreteDecorator(component);
        decorator.operation();
    }
}
