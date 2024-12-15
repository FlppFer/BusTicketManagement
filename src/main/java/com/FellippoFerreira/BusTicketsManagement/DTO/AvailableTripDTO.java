package com.FellippoFerreira.BusTicketsManagement.DTO;

import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AvailableTripDTO {
  private long busTripId;
  private String departureCity;
  private String departureState;
  private String arrivalCity;
  private String arrivalState;
  private Float totalTripDistance;
  private ZonedDateTime departureDateTime;
  private ZonedDateTime arrivalDateTime;
  private float ticketPrice;
  private int availableSeats;
  private int maxLuggagePerPassenger;
}
