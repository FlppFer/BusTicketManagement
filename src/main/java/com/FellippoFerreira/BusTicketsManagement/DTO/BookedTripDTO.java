package com.FellippoFerreira.BusTicketsManagement.DTO;

import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BookedTripDTO {
  private String trackingCode;
  private long busTripId;
  private String departureCity;
  private String departureState;
  private String arrivalCity;
  private String arrivalState;
  private double totalDistance;
  private ZonedDateTime departureDateTime;
  private ZonedDateTime arrivalDateTime;
  private double ticketPrice;
  private String paymentType;
  private int totalInstallments;
  private int passengerCount;
  private int childrenCount;
  private double totalPrice;
  private int luggageCount;
}
