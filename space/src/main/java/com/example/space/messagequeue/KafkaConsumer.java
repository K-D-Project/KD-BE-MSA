package com.example.space.messagequeue;

import com.example.space.model.entity.Space;
import com.example.space.repository.SpaceRepository;
import com.example.space.service.SpaceService;
import com.example.space.service.impl.SpaceServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@Data
public class KafkaConsumer {

    private final SpaceRepository spaceRepository;

    @KafkaListener(topics = "test")
    public void updateSpace(String kafkaMessage){
        log.info("Kafka Message : ->" + kafkaMessage);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try{
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>(){});
        }catch(JsonProcessingException ex){
            ex.printStackTrace();
        }

//        Space entity = spaceRepository.findById((Long)map.get("Id")).get();
//        if(entity != null){
//            spaceRepository.save(entity);
//        }


    }

    @RetryableTopic
    @KafkaListener(topics = "testSecond")
    public void update(String kafkaMessage){
        log.info("Kafka Message : ->->" + kafkaMessage);
        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try{
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>(){});

        }catch(JsonProcessingException ex){
            ex.printStackTrace();
        }

//        Space entity = spaceRepository.findById((Long)map.get("Id")).get();
//        if(entity != null){
//            spaceRepository.save(entity);
//        }


    }
}