package structure.factoryMethodMode;

import java.math.BigDecimal;

/**
 * 定义一个创建对象的接口，让子类决定实例化哪一个类
 */
public class NumberFactoryImpl implements NumberFactory {
    @Override
    public Number parse(String s) {
        return new BigDecimal(s);
    }
}
