package com.xxxx.springboot.job;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Author QJJ
 * @Date 2021-08-18 0:54
 */
public class MyJob implements Job {
    private Logger logger = LoggerFactory.getLogger(MyJob.class);


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        logger.info("触发器"+triggerKey.getName()+"-->所属组："+triggerKey.getGroup()+"-->"+sdf.format(new Date())+"-->"+"hello springboot Quartz..");
    }
}
