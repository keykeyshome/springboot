package com.xxxx.springboot.config;

import com.xxxx.springboot.job.MyJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author QJJ
 * @Date 2021-08-18 1:13
 */
//springboot配置quartz 定时任务


/*
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(MyJob.class).storeDurably().build();
    }

    @Bean
    public Trigger trigger1() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(1).repeatForever();
        return TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(scheduleBuilder)
                .forJob(jobDetail()).build();
    }

    @Bean
    public Trigger trigger2() {
        return TriggerBuilder.newTrigger().withIdentity("trigger2", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? "))
                .forJob(jobDetail()).build();
    }
}
*/
