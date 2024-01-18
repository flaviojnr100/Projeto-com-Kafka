package com.ms.user.service;

import com.ms.user.dto.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private KafkaTemplate<String, EmailDTO> kafkaTemplate;

    public void sendMensagem(String topic, EmailDTO emailDTO){
        this.kafkaTemplate.send(topic,emailDTO);
    }

}
