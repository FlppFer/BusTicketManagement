package com.FellippoFerreira.BusTicketsManagement.DTO;

import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AvailableTripDTO {
  private long busTripId;
  private String departureCity;
  private String departureState;
  private String arrivalCity;
  private String arrivalState;
  private Float totalDistance;
  private ZonedDateTime departureDateTime;
  private ZonedDateTime arrivalDateTime;
  private double ticketPrice;
  private int availableSeats;
  private int maxLuggagePerPassenger;
  private boolean isInterState;
}
