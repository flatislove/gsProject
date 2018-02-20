package com.flatislove.service.impl;

import com.flatislove.model.EmailMessage;
import com.flatislove.service.MailService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

import static java.awt.SystemColor.text;

@Service
public class MailServiceImpl implements MailService{
    private JavaMailSender javaMailSender;

    @Autowired
    public MailServiceImpl(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }

    public void sendNotification(User user){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
         mailMessage.setTo("renadiz@mail.ru");
        mailMessage.setFrom("flatislove@gmail.com");
        mailMessage.setSubject("tyughgjgj");
        mailMessage.setText("hjggggggggggg");

        javaMailSender.send(mailMessage);

    }




//    @Value("${gmail.username}")
//    private String username;
//    @Value("${gmail.password}")
//    private String password;
//
//    @Override
//    public void sendRequestForEmail(EmailMessage emailMessage) throws AddressException{
////        Properties properties = new Properties();
////        properties.put("mail.smtp.auth","true");
////        properties.put("mail.smtp.statlls.enable","true");
////        properties.put("mail.smtp.host", "smtp.gmail.com");
////        properties.put("mail.smtp.port","578");
////
//////        Session session = Session.getInstance(properties,
//////                new javax.mail.Authenticator(){
//////            protected PasswordAuthentication getPasswordAuth(){
//////                return new PasswordAuthentication(username,password);}});
//////        Message msg = new MimeMessage(session);
//////            msg.setFrom(new InternetAddress(username,false));
//////            msg.addRecipient(Message.RecipientType.TO,InternetAddress.parse(emailMessage.getTo_address()));
//////            msg.setSubject(emailMessage.getSubject());
//////            msg.setSubject(emailMessage.getBody(),"text/html)");
//////            msg.setSentDate(new Date());
//////        }
////
//    }


}
