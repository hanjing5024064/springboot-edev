package com.itheima.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Classname MyProperties
 * @Description TODO
 * @Date 2019-3-1 14:54
 * @Created by CrazyStone
 */
//@Component
@Configuration    // 自定义配置类
@EnableConfigurationProperties(MyProperties.class) // 开启对应配置类的属性注入功能
@PropertySource("classpath:test.properties")   // 指定自定义配置文件位置和名称
@ConfigurationProperties(prefix = "test")      // 指定配置文件注入属性前缀
public class MyProperties {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyProperties{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

