package structure.bridgeMode;

public abstract class Bag {
    protected Color color;

    public Bag(Color color) {
        this.color = color;
    }

    public abstract void show();
}
