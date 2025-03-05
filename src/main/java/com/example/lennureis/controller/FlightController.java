package com.example.lennureis.controller;

import com.example.lennureis.model.Flight;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @GetMapping
    public List<Flight> getAllFlights() {
        return List.of(
                new Flight("Tallinn", "Pariis", "2025-03-10", "10:00", 150),
                new Flight("Tallinn", "London", "2025-03-10", "12:00", 200)
        );
    }
}
