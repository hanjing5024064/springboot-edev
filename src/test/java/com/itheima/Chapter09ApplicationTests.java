package com.itheima;

import com.itheima.service.SendEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter09ApplicationTests {
    @Autowired
    private SendEmailService sendEmailService;

    @Test
    public void sendSimpleMailTest() {
        String to="5024064@qq.com";
        String subject="【纯文本邮件】标题";
        String text="Spring Boot纯文本邮件发送内容测试.....";
        // 发送简单邮件
        sendEmailService.sendSimpleEmail(to,subject,text);
    }
}
