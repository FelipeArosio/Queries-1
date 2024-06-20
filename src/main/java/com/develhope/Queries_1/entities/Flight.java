package com.develhope.Queries_1.entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String description;
    private String fromAirport;
    private String toAirport;

    @Enumerated(EnumType.STRING)
    private FlightStatus status;

    public Flight() {
    }

    public Flight(String description, String fromAirport, String toAirport, FlightStatus status) {
        this.description = description;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.status = status;
    }

    // Getters and Setters
}

