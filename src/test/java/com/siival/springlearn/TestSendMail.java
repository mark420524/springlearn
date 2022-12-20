package com.siival.springlearn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class TestSendMail {
	
	@Autowired
	private JavaMailSender mailSender;

	@Test
	public void testSendMail() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("markjava@qq.com");
        // 邮件接收人
        mailMessage.setTo("markjava@foxmail.com");
        // 邮件主题
        mailMessage.setSubject("测试");
        // 邮件内容
        mailMessage.setText("this is a just test");
        mailSender.send(mailMessage);
	}
}
