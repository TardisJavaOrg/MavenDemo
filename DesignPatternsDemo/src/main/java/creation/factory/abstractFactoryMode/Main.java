package creation.factory.abstractFactoryMode;

/**
 * 抽象工厂模式
 * 工厂和产品都是抽象的
 */
public class Main {
    public static void main(String[] args) {
        // 隐藏了工厂的创建过程，和产品的创建过程。都是抽象接口接收对象。
        // 满足里氏替换原则
        AbstractFactory factory1 = new AliFactory();
        ProductA productA1 = factory1.createA(); // 阿里生产的产品A
        productA1.info();
        AbstractFactory factory2 = new TencentFactory();
        ProductA productA2 = factory2.createA(); // 腾讯生产的产品A
        productA2.info();

        // 配合 工厂方法设计模式，隐藏工厂的创建细节
        AbstractFactory factory = AbstractFactory.createFactory("ali");
        ProductB productB1 = factory.createB();
        productB1.info();
    }

}
