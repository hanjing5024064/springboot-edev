package com.itheima;

import com.itheima.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * IDEA开发工具快捷方式自动创建的主程序启动类对应的单元测试类
 */
@RunWith(SpringRunner.class)   // 测试启动器，并加载Spring Boot测试注解
@SpringBootTest       // 标记为Spring Boot单元测试类，并加载项目的ApplicationContext上下文环境
public class Chapter01ApplicationTests {

    // 自动创建的单元测试方法示例
    @Test
    public void contextLoads() {
    }

    @Autowired
    private HelloController helloController;
    @Test
    public void helloControllerTest() {
        String hello = helloController.hello();
        System.out.println(hello);
    }

}
