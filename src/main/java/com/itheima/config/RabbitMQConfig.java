package com.itheima.config;

import org.springframework.amqp.core.*;
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
     * 定制JSON格式的消息转换器，将消息序列化
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    /**
     * 使用基于配置类的方式定制消息中间件
     * @return
     */
    // 1、定义fanout类型的交换器
    @Bean
    public Exchange fanout_exchange(){
        return ExchangeBuilder.fanoutExchange("fanout_exchange").build();
    }
    // 2、定义两个不同名称的消息队列
    @Bean
    public Queue fanout_queue_email(){
        return new Queue("fanout_queue_email");
    }
    @Bean
    public Queue fanout_queue_sms(){
        return new Queue("fanout_queue_sms");
    }
    // 3、将两个不同名称的消息队列与交换器进行绑定
    @Bean
    public Binding bindingEmail(){
        return BindingBuilder.bind(fanout_queue_email()).to(fanout_exchange()).with("").noargs();
    }
    @Bean
    public Binding bindingSms(){
        return BindingBuilder.bind(fanout_queue_sms()).to(fanout_exchange()).with("").noargs();
    }
}
