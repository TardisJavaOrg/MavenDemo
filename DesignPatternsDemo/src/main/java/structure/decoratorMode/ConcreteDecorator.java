package structure.decoratorMode;

/**
 * @author timothy
 * @data 2021年05月21日 8:35 下午
 * 具体装饰器，可以有多种装饰器，用来装饰 Component
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addFunction();
    }

    private void addFunction() {
        System.out.println("额外的功能");
    }
}
