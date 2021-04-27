package com.itheima.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Classname DevDBConnector
 * @Description TODO
 * @Date 2019-3-1 15:06
 * @Created by CrazyStone
 */
@Configuration
@Profile("dev")    // 指定多环境配置类标识
public class DevDBConnector implements DBConnector {
    @Override
    public void configure() {
        System.out.println("数据库配置环境dev");
    }
}

