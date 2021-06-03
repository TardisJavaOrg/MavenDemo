package creation.factory.staticFactoryMethodMode;

import java.math.BigDecimal;

/**
 * @author timothy
 * @data 2021年05月21日 3:00 下午
 * 静态工厂方法
 */
public class NumberFactory {
    public static Number parse(String s) {
        return new BigDecimal(s);
    }
}
