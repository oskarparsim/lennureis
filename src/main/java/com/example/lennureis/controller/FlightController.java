package com.example.lennureis.controller;

import com.example.lennureis.model.Flight;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final List<Flight> flights = List.of(
            new Flight("Tallinn", "Pariis", "2025-03-10", "10:00", 150),
            new Flight("Tallinn", "London", "2025-03-10", "12:00", 200),
            new Flight("Tartu", "Pariis", "2025-03-11", "09:00", 180)
    );

    @GetMapping
    public List<Flight> getAllFlights() {
        return flights;
    }

    @GetMapping("/search")
    public List<Flight> searchFlights(
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) String date,
            @RequestParam(required = false) String departure) {

        return flights.stream()
                .filter(flight -> destination == null || flight.getDestination().equalsIgnoreCase(destination))
                .filter(flight -> date == null || flight.getDate().equals(date))
                .filter(flight -> departure == null || flight.getDeparture().equalsIgnoreCase(departure))
                .collect(Collectors.toList());
        }
}