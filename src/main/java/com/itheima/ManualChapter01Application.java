package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

//@ImportResource("classpath:beans.xml") // 加载自定义XML配置文件位置
@EnableCaching   //  开启Spring Boot基于注解的缓存管理支持
@ServletComponentScan  // 开启基于注解方式的Servlet组件扫描支持
@SpringBootApplication
public class ManualChapter01Application extends SpringBootServletInitializer {
    // 3、程序主类继承SpringBootServletInitializer，并重写configure()方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ManualChapter01Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ManualChapter01Application.class, args);
    }

}