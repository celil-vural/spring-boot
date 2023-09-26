package com.springbootaop.api;

import com.springbootaop.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class MessageApi {
    @Autowired
    private MessageService messageService;
    @PostMapping
    public ResponseEntity<String> postMethod(@RequestBody String message){
        return ResponseEntity.ok(messageService.getMessage(message));
    }
}
