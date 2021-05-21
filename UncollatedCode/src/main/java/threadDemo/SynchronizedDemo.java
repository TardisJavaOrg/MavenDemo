package threadDemo;

public class SynchronizedDemo {
    public void sync() {
        synchronized (this) {
            System.out.println("");
        }
    }

    public static void main(String[] args) {
    }
}