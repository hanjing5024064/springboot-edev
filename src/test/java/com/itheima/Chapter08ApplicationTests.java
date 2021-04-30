package com.itheima;

import com.itheima.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter08ApplicationTests {
    @Autowired
    private AmqpAdmin amqpAdmin;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 使用AmqpAdmin管理员API定制消息组件®
     */
    @Test
    public void amqpAdmin() {
        // 1、定义fanout类型的交换器
        amqpAdmin.declareExchange(new FanoutExchange("fanout_exchange"));
        // 2、定义两个默认持久化队列，分别处理email和sms
        amqpAdmin.declareQueue(new Queue("fanout_queue_email"));
        amqpAdmin.declareQueue(new Queue("fanout_queue_sms"));
        // 3、将队列分别与交换器进行绑定
        amqpAdmin.declareBinding(new Binding("fanout_queue_email",Binding.DestinationType.QUEUE,"fanout_exchange","",null));
        amqpAdmin.declareBinding(new Binding("fanout_queue_sms",Binding.DestinationType.QUEUE,"fanout_exchange","",null));
    }

    /**
     * 1、Publish/Subscribe工作模式消息发送端
     */
    @Test
    public void psubPublisher() {
        User user=new User();
        user.setId(1);
        user.setUsername("石头");
        rabbitTemplate.convertAndSend("fanout_exchange","",user);
    }

    /**
     *	2、Routing工作模式消息发送端
     */
    @Test
    public void routingPublisher() {
        rabbitTemplate.convertAndSend("routing_exchange","error_routing_key","routing send error message");
    }

    /**
     *	3、Topcis工作模式消息发送端
     */
    @Test
    public void topicPublisher() {
        // 1、只发送邮件订阅用户消息
//        rabbitTemplate.convertAndSend("topic_exchange","info.email","topics send  email message");
        // 2、只发送短信订阅用户消息
//	    rabbitTemplate.convertAndSend("topic_exchange","info.sms","topics send  sms message");
        // 3、发送同时订阅邮件和短信的用户消息
        rabbitTemplate.convertAndSend("topic_exchange","info.email.sms","topics send  email and sms message");
    }
}



