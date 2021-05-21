package threadDemo;

/**
 * 守护进程
 */
public class DaemonDemo {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("I am alive.");
                    Thread.yield();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("finally block");
                }
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();
        // 确保main线程结束钱嫩个给到足够的时间片
        try {
            Thread.sleep(500);// 500 是最低时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
