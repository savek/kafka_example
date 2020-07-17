package com.savek.example.kafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.savek.example.kafka.dto.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/rest")
public class MessageController {

    @Autowired
    @Qualifier("kafkaStringTemplate")
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/{message}")
    public String sendOrder(@PathVariable("message") String message){
        String msgId = "test";
        kafkaTemplate.send("msg", msgId, message);

        return "ok";
    }
}