package com.springbootevents.event.listener;

import com.springbootevents.event.ReservationCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ReservationEventListener {
    @EventListener
    public void reservationEventHandler(ReservationCreatedEvent reservationCreatedEvent) {
        System.out.println("Reservation Created Event Handler");
        System.out.println(reservationCreatedEvent.getSource().toString());
    }
}
