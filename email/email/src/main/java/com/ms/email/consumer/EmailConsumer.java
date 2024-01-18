package com.ms.email.consumer;

import com.ms.email.model.EmailDTO;
import com.ms.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @KafkaListener(topics = "email", groupId = "0",containerFactory = "emailListener")
    public void receberMensagens(EmailDTO emailDTO){

        this.emailService.sendEmail(emailDTO.email(),"Boa vindas",emailDTO.message());
        System.out.println("Email enviado");


    }
}
