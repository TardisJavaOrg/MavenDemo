package structure.decoratorMode;

/**
 * @author timothy
 * @data 2021年05月21日 8:31 下午
 * 具体构建类
 */
public class ConcreteComponent implements Component {
    public ConcreteComponent() {
        System.out.println("具体构建类");
    }

    @Override
    public void operation() {
        System.out.println("具体构建操作");
    }
}
