package com.FellippoFerreira.BusTicketsManagement.Model;

import com.FellippoFerreira.BusTicketsManagement.DTO.State;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Table(name = "available_trips")
public class AvailableTripModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private long busTripId;
  private String departureCity;
  private State departureState;
  private String arrivalCity;
  private String arrivalState;
  private Float totalTripDistance;
  private ZonedDateTime departureDateTime;
  private ZonedDateTime arrivalDateTime;
  private float ticketPrice;
  private int availableSeats;
  private int maxLuggagePerPassenger;
}
