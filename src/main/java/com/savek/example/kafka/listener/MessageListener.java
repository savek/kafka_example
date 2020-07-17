package com.savek.example.kafka.listener;

import com.savek.example.kafka.dto.Address;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    Logger logger = LoggerFactory.getLogger(MessageListener.class);

    @KafkaListener(topics="msg", groupId = "kafka.group.id.string")
    public void msgListener(String msg){
        logger.info("--> {}", msg);
    }

    @KafkaListener(topics="dto", groupId = "kafka.group.id.dto", containerFactory = "dtoFactory")
    public void dtoListener(ConsumerRecord<String, Address> record){
        Address address = record.value();
        logger.info("--> {}", address);
    }
}
