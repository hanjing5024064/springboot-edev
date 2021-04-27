package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Classname DataSourceConfig
 * @Description 自定义数据源配置类
 * @Date 2019-3-1 15:30
 * @Created by CrazyStone
 */
@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDruid(){
        return new DruidDataSource();
    }
}

