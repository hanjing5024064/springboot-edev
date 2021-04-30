package com.itheima.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname RabbitMQConfig
 * @Description RabbitMQ消息配置类
 * @Date 2019-3-8 14:15
 * @Created by CrazyStone
 */
@Configuration
public class RabbitMQConfig {
    /**
     * 定制JSON格式的消息转换器
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
