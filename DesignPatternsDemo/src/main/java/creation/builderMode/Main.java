package creation.builderMode;

/**
 * @author timothy
 * @data 2021年05月21日 3:38 下午
 * 建造者模式
 */
public class Main {
    public static void main(String[] args) {
        Director director = new Director(new ConcreteBuilder());
        Product product = director.construct();
        System.out.println(product.getPartA() + ":" + product.getPartB() + ":" + product.getPartC());
    }
}
