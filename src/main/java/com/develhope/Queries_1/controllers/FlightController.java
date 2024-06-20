package com.develhope.Queries_1.controllers;


import com.develhope.Queries_1.entities.Flight;
import com.develhope.Queries_1.entities.FlightStatus;
import com.develhope.Queries_1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @PostMapping("/provision")
    public void provisionFlights() {
        List<Flight> flights = IntStream.range(0, 50)
                .mapToObj(i -> new Flight(
                        generateRandomString(),
                        generateRandomString(),
                        generateRandomString(),
                        FlightStatus.ONTIME
                )).collect(Collectors.toList());

        flightRepository.saveAll(flights);
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    private String generateRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}

