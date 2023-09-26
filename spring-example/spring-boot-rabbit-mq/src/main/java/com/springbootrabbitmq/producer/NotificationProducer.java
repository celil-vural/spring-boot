package com.springbootrabbitmq.producer;

import com.springbootrabbitmq.model.Notification;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NotificationProducer {
    @Value("${spring.rabbitmq.routingkey.name}")
    private String routingName;
    @Value("${spring.rabbitmq.exchange.name}")
    private String exchangeName;
    private RabbitTemplate rabbitTemplate;
    public NotificationProducer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @PostConstruct
    public void init(){
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setNotificationDate(new java.util.Date());
        notification.setSeen(Boolean.FALSE);
        notification.setMessage("This is a notification message");
        sendToQueue(notification);
    }
    public void sendToQueue(Notification notification) {
        System.out.println("Notification Sent ID: " +notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName,routingName, notification);
    }
}
