package com.itheima.config;

import com.itheima.servletComponent.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 嵌入式Servlet容器三大组件配置
 */
@Configuration
public class ServletConfig {
    // 注册Servlet组件
    @Bean
    public ServletRegistrationBean getServlet(MyServlet myServlet){
        ServletRegistrationBean registrationBean =
                new ServletRegistrationBean(myServlet,"/myServlet");
        return registrationBean;
    }
}

