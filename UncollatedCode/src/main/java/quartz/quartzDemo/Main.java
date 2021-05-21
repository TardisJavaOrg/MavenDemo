package quartz.quartzDemo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // 创建任务
        JobDetail detail = JobBuilder.newJob(MyJob.class)
                .usingJobData("name", "tardis") // 放入JobData
                .withDescription("what the fuck")
                .withIdentity("job1", "group1")
                .build();
        // 创建触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .usingJobData("name", "tardis") // 放入JobData
                .withIdentity("trigger1", "group2")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1)
                        .repeatForever())
                .build();

        // 使用调度器调度
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            scheduler.scheduleJob(detail, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}

class MyJob implements Job {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException{
        JobDataMap detailMap = context.getJobDetail().getJobDataMap();
        JobDataMap triggerMap = context.getTrigger().getJobDataMap();
//        System.out.println("name:" + name);
        // 获取detail和trigger中的JobDataMap trigger的覆盖job的

        JobDataMap mergeMap = context.getMergedJobDataMap();
        System.out.println("MyJob execute:" + new Date());
    }
}