import java.util.Scanner;

public class OrderThread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            Object a = new Object();
            Object b = new Object();
            Object c = new Object();
            Object d = new Object();
            Thread thread1 = new Thread(new ThreadPrint("A", a, b, n));
            Thread thread2 = new Thread(new ThreadPrint("B", b, c, n));
            Thread thread3 = new Thread(new ThreadPrint("C", c, d, n));
            Thread thread4 = new Thread(new ThreadPrint("D", d, a, n));
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
        }
    }


}

class ThreadPrint implements Runnable {
    private static int newIndex = 0;
    private static int runIndex = 0;
    private boolean isFirstRun = true;
    private Object self;
    private Object next;
    private String name;
    private int id;
    private int num;

    public ThreadPrint(String name, Object self, Object next, int num) {
        id = newIndex++;
        this.name = name;
        this.self = self;
        this.next = next;
        this.num = num;
    }

    @Override
    public void run() {
        while (num > 0) {
            synchronized (self) {
                if (id > runIndex) {
                    try {
                        self.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(name);
                if (isFirstRun) {
                    runIndex++;
                    isFirstRun = false;
                }
                synchronized (next) {
                    next.notify();
                }
                num--;
                if (num > 0) {
                    try {
                        self.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}