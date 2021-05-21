package creation.builderMode;

/**
 * @author timothy
 * @data 2021年05月21日 3:33 下午
 * 具体创建者
 */
public class ConcreteBuilder implements Builder {
    @Override
    public void builderPartA() {
        product.setPartA("partA");
    }

    @Override
    public void builderPartB() {
        product.setPartB("partB");
    }

    @Override
    public void builderPartC() {
        product.setPartC("partC");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
