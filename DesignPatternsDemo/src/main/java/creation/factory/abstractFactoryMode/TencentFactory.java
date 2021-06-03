package creation.factory.abstractFactoryMode;

/**
 * 腾讯工厂
 */
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
