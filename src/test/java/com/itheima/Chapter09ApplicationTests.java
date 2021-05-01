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

    @Test
    public void sendComplexEmailTest() {
        String to="2127269781@qq.com";
        String subject="【复杂邮件】标题";
        // 定义邮件内容
        StringBuilder text = new StringBuilder();
        text.append("<html><head></head>");
        text.append("<body><h1>祝大家元旦快乐！</h1>");
        // cid为固定写法，rscId指定一个唯一标识
        String rscId = "img001";
        text.append("<img src='cid:" +rscId+"'/></body>");
        text.append("</html>");
        // 指定静态资源文件和附件路径
        String rscPath="\\email\\newyear.jpg";
        String filePath="\\email\\元旦放假注意事项.docx";
        // 发送复杂邮件
        sendEmailService.sendComplexEmail(to,subject,text.toString(),filePath,rscId,rscPath);
    }
}
