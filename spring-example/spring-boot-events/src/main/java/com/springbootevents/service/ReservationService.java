package com.springbootevents.service;

import com.springbootevents.event.ReservationCreatedEvent;
import com.springbootevents.model.HotelBookRequest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final ApplicationEventPublisher applicationEventPublisher;

    public ReservationService(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Async
    public void publishReservationEvent(HotelBookRequest request) {
        applicationEventPublisher.publishEvent(new ReservationCreatedEvent(request));
    }
}
