package structure.factoryMethodMode;

public interface NumberFactory {
    NumberFactory impl = new NumberFactoryImpl();
    static NumberFactory getFactory(){
        return impl;
    }
    Number parse(String s);
}
