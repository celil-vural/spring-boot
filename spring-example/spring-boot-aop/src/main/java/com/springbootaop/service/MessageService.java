package com.springbootaop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String getMessage(String param){
        System.out.println(param);
        return param;
    }
}
