package com.springbootrabbitmq.handler;

import com.springbootrabbitmq.model.Notification;
import com.springbootrabbitmq.producer.NotificationProducer;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class NotificationSender {
    private NotificationProducer producer;
    public NotificationSender(final NotificationProducer producer) {
        this.producer = producer;
    }
    public void getThread() {
        Thread thread = new Thread(() -> {
            while (true) {
                Notification notification = new Notification();
                notification.setNotificationId(UUID.randomUUID().toString());
                notification.setNotificationDate(new Date());
                notification.setMessage("Mesaj var...");
                notification.setSeen(false);
                producer.sendToQueue(notification);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("Notification sender");
        thread.start();
    }


    @PostConstruct
    public void init() {
        getThread();

    }
}
