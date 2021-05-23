package creation.builderMode;

/**
 * @author timothy
 * @data 2021年05月21日 3:38 下午
 * 建造者模式
 * 屏蔽 商品的常见细节，通过调度者 调度builder 构建 商品
 */
public class Main {
    public static void main(String[] args) {
        Director director = new Director(new ConcreteBuilder());
        Product product = director.construct();
        System.out.println(product.getPartA() + ":" + product.getPartB() + ":" + product.getPartC());
    }
}
