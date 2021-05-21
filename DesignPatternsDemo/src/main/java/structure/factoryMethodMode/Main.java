package structure.factoryMethodMode;

/**
 * 工厂方法是指定义工厂接口和产品接口，但如何创建实际工厂和实际产品被推迟到子类实现，从而使调用方只和抽象工厂与抽象产品打交道。
 *
 * 实际更常用的是更简单的静态工厂方法，它允许工厂内部对创建产品进行优化。
 *
 * 调用方尽量持有接口或抽象类，避免持有具体类型的子类，以便工厂方法能随时切换不同的子类返回，却不影响调用方代码。
 */
public class Main {
    public static void main(String[] args) {
        // 要 隐藏 创建的细节，通常使用静态工厂方法就可以了，不用使用下面这种 繁琐的方式
        NumberFactory factory = NumberFactory.getFactory();
        Number parse = factory.parse("123");
    }
}
