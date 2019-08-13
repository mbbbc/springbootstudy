package com.bssw.scheduler;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableScheduling
@Component
public class SchedulingConfig {
    private static final SimpleDateFormat dateFormat =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     *通过cron设置 每天16:42执行
     */
    @Scheduled(cron="0 42 16 * * ?")
    private void schedulerTask1(){
        System.out.println("time is 16:42 now ! start running");
        int i = 0;
        while(true){
            System.out.println(i++);
        }
    }

    /**
     * fixedRate：上一次开始执行时间点之后1秒再执行， 以毫秒为单位
     */
    //@Scheduled(fixedRate=1 * 1000)
    private void schedulerTask2(){
        System.out.println("schedulerTask2 is running ...");
        System.out.println(dateFormat.format(new Date()));
        System.out.println("schedulerTask2 done");
    }

    /**
     *fixedDelay:上一次执行完毕时间点之后5秒再执行
     */
    @Scheduled(fixedDelay = 5 * 1000)
    private void schedulerTask3(){
        System.out.println("schedulerTask3 is running ...");
        System.out.println(dateFormat.format(new Date()));
        System.out.println("schedulerTask3 done");
    }
}
