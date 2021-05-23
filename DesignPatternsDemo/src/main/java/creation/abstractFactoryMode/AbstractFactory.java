package creation.abstractFactoryMode;

/**
 * 工厂是抽象的，产品也是抽象的
 */
public interface AbstractFactory {

    // 创建产品A
    ProductA createA();

    // 创建产品B
    ProductB createB();

    /**
     * 配合 工厂方法 设计模式 隐藏工厂的创建细节
     *
     * @param supplier 供应商名称
     */
    static AbstractFactory createFactory(String supplier) {
        if (supplier.equalsIgnoreCase("tencent")) {
            return new TencentFactory();
        } else if (supplier.equalsIgnoreCase("ali")) {
            return new AliFactory();
        } else {
            throw new IllegalArgumentException("Invalid factory name");
        }
    }
}
