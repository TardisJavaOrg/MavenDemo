package structure.bridgeMode;

/**
 * @author timothy
 * @data 2021年05月21日 7:37 下午
 * 当一个类有多个子类，并且每个类有多种属性时，可以使用桥接模式
 */
public class Main {
    public static void main(String[] args) {
        HandBag handBag = new HandBag(new Red());
        handBag.show();
    }
}
