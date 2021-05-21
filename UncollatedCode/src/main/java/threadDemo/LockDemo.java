package threadDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    Lock lock = new ReentrantLock(true); // 公平锁

    void method(Thread thread) {
//        lock.lock();
//        try {
//            System.out.println(thread.getName() + " locked.");
//            Thread.sleep(1000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            System.out.println(thread.getName() + " unlock.");
//            lock.unlock();
//        }

        try {
            lock.lock(); // 获取锁，没有获取就阻塞
//            lock.lockInterruptibly(); // 如果当前线程被意外中断则抛错
            System.out.println(thread.getName() + " locked.");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(thread.getName() + " unlock.");
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        LockDemo lock = new LockDemo();
        Thread t1 = new Thread(() -> {
            lock.method(Thread.currentThread());
        }, "t1");

        Thread t2 = new Thread(() -> {
            lock.method(Thread.currentThread());
        }, "t2");

        t1.start();
        t2.start();
    }
}
