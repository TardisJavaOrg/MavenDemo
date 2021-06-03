package creation.factory.factoryMethodMode;

/**
 * @author timothy
 * @data 2021年05月22日 7:11 下午
 */
public class Product1Factory implements Factory {
    @Override
    public Product newProduct() {
        return new ConcreteProduct1();
    }
}
