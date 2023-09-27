package com.springbootevents.event;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class ReservationCreatedEvent extends ApplicationEvent {
    public ReservationCreatedEvent(Object source) {
        super(source);
    }

    public ReservationCreatedEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
