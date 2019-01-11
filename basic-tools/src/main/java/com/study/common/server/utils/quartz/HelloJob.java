package com.study.common.server.utils.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

@Slf4j
public class HelloJob implements Job {

    public HelloJob() {
    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException {
//        log.info("Hello World! - " + new Date());
        System.out.println("HelloJob! - " + context.getFireInstanceId() + ",date:" + System.nanoTime());
    }

}