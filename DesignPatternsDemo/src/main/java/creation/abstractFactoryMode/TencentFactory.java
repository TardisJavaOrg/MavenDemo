package creation.abstractFactoryMode;

public class TencentFactory implements AbstractFactory {
    @Override
    public ProductA createA() {
        return new SupplierATencent();
    }

    @Override
    public ProductB createB() {
        return new SupplierBTencent();
    }
}
