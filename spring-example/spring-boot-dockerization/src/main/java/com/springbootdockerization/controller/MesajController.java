package com.springbootdockerization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mesaj")
public class MesajController {
    @GetMapping
    public String mesaj() {
        return "Merhaba Docker!";
    }
}
