package com.springbootevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBootEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEventsApplication.class, args);
    }

}
