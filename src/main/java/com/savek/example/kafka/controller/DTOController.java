package com.savek.example.kafka.controller;

import com.savek.example.kafka.dto.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class DTOController {

    @Autowired
    @Qualifier("kafkaDTOTemplate")
    private KafkaTemplate<String, Address> kafkaTemplate;

    @PostMapping
    public String sendMessage(@RequestBody Address message) {
        String msgId = "test";
        kafkaTemplate.send("dto", msgId, message);

        return "Ok";
    }
}
