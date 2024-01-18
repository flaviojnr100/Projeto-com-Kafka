package com.ms.email.custom;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.email.model.EmailDTO;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class CustomEmail implements Deserializer<EmailDTO> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public EmailDTO deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, EmailDTO.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
