package creation.builderMode;

public interface Builder {
    Product product = new Product();

    void builderPartA();

    void builderPartB();

    void builderPartC();

    Product getResult();
}
