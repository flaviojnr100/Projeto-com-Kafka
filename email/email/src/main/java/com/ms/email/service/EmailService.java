package com.ms.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String dest, String title, String body){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(dest);
        simpleMailMessage.setSubject(title);
        simpleMailMessage.setText(body);

        javaMailSender.send(simpleMailMessage);
    }
}
