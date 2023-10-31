package com.example.ui.messagequeue;

import com.example.ui.model.response.MessageDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Data
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageDto send(String topic, MessageDto messageDto){
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        try{
            jsonInString = mapper.writeValueAsString(messageDto);
        }catch(JsonProcessingException ex){
            ex.printStackTrace();
        }

        kafkaTemplate.send(topic, jsonInString);
        log.info("Kafka Producer sent data from the Ui microservice:: " + messageDto);

        return messageDto;
    }

}