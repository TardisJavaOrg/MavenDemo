package structure.decoratorMode;

/**
 * @author timothy
 * @data 2021年05月21日 8:35 下午
 * 抽象装饰器
 */
public class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
