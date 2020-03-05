package com.example.websocket.controller;

import com.example.websocket.model.ChatInput;
import com.example.websocket.model.ChatOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class ChatAppController {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
    @RequestMapping("/start")
    public String start() {
        return "start";
    }

    //send all
    @RequestMapping("/message")
    @ResponseBody
    public String chat() {
        this.messagingTemplate.convertAndSend("/topic/notification","TEST");
        return "OK";
    }


}