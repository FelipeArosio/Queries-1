package com.develhope.Queries_1.repositories;

import com.develhope.Queries_1.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FlightRepository extends JpaRepository<Flight, UUID> {
}

