package creation.builderMode;

/**
 * @author timothy
 * @data 2021年05月21日 3:35 下午
 * 调度器
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        builder.builderPartA();
        builder.builderPartB();
        builder.builderPartC();
        return builder.getResult();
    }
}
