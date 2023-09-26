package com.springbootrabbitmq.listener;

import com.springbootrabbitmq.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {
    @RabbitListener(queues = "${spring.rabbitmq.queue.name}")
    public void handleMessage(Notification notification) {
        System.out.println("Message Received From RabbitMQ");
        System.out.println("Message Received: " +notification.toString());
    }
}
