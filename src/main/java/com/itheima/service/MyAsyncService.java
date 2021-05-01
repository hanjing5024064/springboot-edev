package com.itheima.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @Classname MyAsyncService
 * @Description TODO
 * @Date 2019-3-11 13:29
 * @Created by CrazyStone
 */
@Service
public class MyAsyncService {
    /**
     * 模拟无返回值的异步任务处理
     * @throws Exception
     */
    @Async
    public void sendSMS() throws Exception {
        System.out.println("调用短信验证码业务方法...");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        Long endTime = System.currentTimeMillis();
        System.out.println("短信业务执行完成耗时：" + (endTime - startTime));
    }
}
