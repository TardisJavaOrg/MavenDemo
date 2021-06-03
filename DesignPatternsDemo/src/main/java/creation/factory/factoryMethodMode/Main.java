package creation.factory.factoryMethodMode;


/**
 * 工厂方法是指 定义工厂接口和产品接口，但创建 实际工厂 和 实际产品 被推迟到 子类 实现，从而使调用方只和 抽象工厂  与抽象产品 打交道。
 * <p>
 * 实际更常用的是更简单的静态工厂方法，它允许工厂内部对创建产品进行优化。
 * <p>
 * 调用方尽量持有接口或抽象类，避免持有具体类型的子类，以便工厂方法能随时切换不同的子类返回，却不影响调用方代码。
 */
public class Main {
    public static void main(String[] args) {
        // 要 隐藏 创建的细节，通常使用静态工厂方法就可以了，不用使用下面这种 繁琐的方式
        Product1Factory product1Factory = new Product1Factory();
        Product product1 = product1Factory.newProduct();
        product1.show();

        Product2Factory product2Factory = new Product2Factory();
        Product product2 = product2Factory.newProduct();
        product2.show();
    }
}
