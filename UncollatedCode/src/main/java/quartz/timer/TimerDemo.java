package quartz.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer(); // 任务启动
        for (int i = 0; i < 2; i++) {
            FooTimerTask task = new FooTimerTask("foo_" + i);
            timer.scheduleAtFixedRate(task, new Date(), 2000); // 任务添加
            // executionTime
            // schedule 离上一个任务的间隔2000
            // scheduleAtFixedRate  严格按照预设时间来
            // 单线程任务阻塞导致的
        }
        System.out.println("success");
    }
}

class FooTimerTask extends TimerTask {

    private String name;

    public FooTimerTask(String name) {
        this.name = name;
    }

    public void run() {
        try {
            System.out.println("name:" + name +" "+ new Date());
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

