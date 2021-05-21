package quartz.schedulerThreadPoolDemo;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class threadPoolDemo {


    /**
     *
     */
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 2; i++) {

            pool.scheduleAtFixedRate(new Task("name-" + i)
                    , 0, 2, TimeUnit.SECONDS);
        }
    }

}

class Task implements Runnable {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + "start___" + new Date());
            Thread.sleep(2000);
            System.out.println(name + "end___" + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}