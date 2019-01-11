package com.study.common.server.utils.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;
import java.text.ParseException;

/**
 * @ClassName QuartzDemo
 * @Description TODO
 * @Author xinbang
 * @Date 2018/11/12 16:31
 * @Version 1.0
 **/

public class QuartzDemo {

    public void run() throws SchedulerException, ParseException, IOException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

//        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
//                .withIdentity("jobDetail1", "group1").storeDurably().withDescription("learn self").build();

        for (int i = 0; i < 10; i++) {
            JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("jobDetail" + i, "group1").storeDurably().withDescription("learn self").build();


            Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(" 0/1 * * * * ?"))
                    .withDescription("trigger description")
                    .withIdentity("trigger" + i, "group1")
                    .startNow()
                    .forJob(jobDetail)
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);

        }


//        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(" 0/1 * * * * ?"))
//                .withDescription("trigger description")
//                .withIdentity("trigger1", "group1")
//                .startNow()
//                .forJob(jobDetail)
//                .build();


        scheduler.start();

        System.in.read();

        scheduler.shutdown(true);
    }

    public static void main(String[] args) {
        try {
            new QuartzDemo().run();
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
