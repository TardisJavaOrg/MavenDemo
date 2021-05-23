package creation.abstractFactoryMode;

/**
 * 供应商工厂
 */
public class AliFactory implements AbstractFactory {

    /**
     * 创建 ali 的 A 产品供应商
     *
     * @return
     */
    @Override
    public ProductA createA() {
        return new SupplierAAli();
    }

    /**
     * 创建 ali 的 B 产品供应商
     *
     * @return
     */
    @Override
    public ProductB createB() {
        return new SupplierBAli();
    }
}
