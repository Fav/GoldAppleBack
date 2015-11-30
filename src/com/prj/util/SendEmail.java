package com.prj.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
 
/**
 * 
 * @author 
 */
public class SendEmail {
     
	public static void send(String fromMail, String user, String password1,
			String toMail, String mailTitle, String mailContent) throws MessagingException {

			final String username =user;// "username@gmail.com";
			final String password =password1;// "password";

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.163.com");
			props.put("mail.smtp.port", "25");

			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });

			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(fromMail));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toMail));
				message.setSubject("Testing Subject");
				message.setText("Dear Mail Crawler,"
					+ "\n\n No spam to my email, please!");
				//Session.getDefaultInstance(props, authentic); 
				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
	}
    public static void Test() throws Exception {  
        send("f115457@163.com", "f115457", "f1154571",  
                "f25457@qq.com",  
                "Java Mail 测试邮件",  
                "<a>html 元素</a>：<b>邮件内容</b>");  
    }  
}