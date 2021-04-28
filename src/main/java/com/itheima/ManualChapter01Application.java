package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

//@ImportResource("classpath:beans.xml") // 加载自定义XML配置文件位置
@ServletComponentScan  // 开启基于注解方式的Servlet组件扫描支持
@SpringBootApplication
public class ManualChapter01Application {

    public static void main(String[] args) {
        SpringApplication.run(ManualChapter01Application.class, args);
    }

}