package com.springbootwebsocket.api;

import com.springbootwebsocket.model.WsMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Controller
@CrossOrigin
public class ChatController {
    private SimpMessagingTemplate simpMessagingTemplate;

    public ChatController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/chat")
    public void chatEndpoint(@Payload  WsMessage wsMessage) {
        System.out.println(wsMessage);
        simpMessagingTemplate.convertAndSend("/topic", wsMessage);
    }
}
