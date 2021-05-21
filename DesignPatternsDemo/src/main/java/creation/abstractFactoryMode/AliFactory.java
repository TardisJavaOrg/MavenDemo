package creation.abstractFactoryMode;

public class AliFactory implements AbstractFactory {
    @Override
    public ProductA createA() {
        return new SupplierAAli();
    }

    @Override
    public ProductB createB() {
        return new SupplierBAli();
    }
}
