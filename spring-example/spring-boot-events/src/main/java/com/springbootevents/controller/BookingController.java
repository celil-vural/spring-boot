package com.springbootevents.controller;

import com.springbootevents.model.HotelBookRequest;
import com.springbootevents.service.ReservationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
    private final ReservationService service;

    public BookingController(ReservationService service) {
        this.service = service;
    }

    @PostMapping
    public void bookHotel(@RequestBody HotelBookRequest hotelBookRequest){
        service.publishReservationEvent(hotelBookRequest);
        System.out.println("Hotel Booked Successfully");
    }
}
