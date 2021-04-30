package com.itheima.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Classname RabbitMQService
 * @Description RabbitMQ消息接收处理的业务类
 * @Date 2019-3-8 14:20
 * @Created by CrazyStone
 */
@Service
public class RabbitMQService {
    /**
     * Publish/Subscribe工作模式接收，处理邮件业务
     * @param message
     */
    @RabbitListener(queues = "fanout_queue_email")//也可以使用RabbitTemplate的receiveSendAndConvert()
    public void psubConsumerEmail(Message message) {
        byte[] body = message.getBody();
        String s = new String(body);
        System.out.println("邮件业务接收到消息： "+s);
    }
    /**
     * Publish/Subscribe工作模式接收，处理短信业务
     * @param message
     */
    @RabbitListener(queues = "fanout_queue_sms")
    public void psubConsumerSms(Message message) {
        byte[] body = message.getBody();
        String s = new String(body);
        System.out.println("短信业务接收到消息： "+s);
    }
}
