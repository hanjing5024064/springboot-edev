package com.itheima.controller;

import com.itheima.service.MyAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname MyAsyncController
 * @Description TODO
 * @Date 2019-3-11 13:36
 * @Created by CrazyStone
 */
@RestController
public class MyAsyncController {
    @Autowired
    private MyAsyncService myService;

    @GetMapping("/sendSMS")
    public String sendSMS() throws Exception {
        Long startTime = System.currentTimeMillis();
        myService.sendSMS();
        Long endTime = System.currentTimeMillis();
        System.out.println("主流程耗时： "+(endTime-startTime));
        return "success";
    }
}
