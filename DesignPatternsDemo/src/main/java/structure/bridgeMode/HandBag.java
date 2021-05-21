package structure.bridgeMode;

/**
 * @author timothy
 * @data 2021年05月21日 7:53 下午
 */
public class HandBag extends Bag {
    public HandBag(Color color) {
        super(color);
    }

    @Override
    public void show() {
        System.out.println("hand bag color :" + this.color.show());
    }
}
