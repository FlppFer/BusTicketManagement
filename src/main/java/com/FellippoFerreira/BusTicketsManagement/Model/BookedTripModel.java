package com.FellippoFerreira.BusTicketsManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "booked_trips")
@Getter
@Setter
public class BookedTripModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

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
  private int luggageCount;
  private double totalPrice;
}
