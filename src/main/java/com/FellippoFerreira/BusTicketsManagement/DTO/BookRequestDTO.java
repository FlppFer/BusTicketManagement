package com.FellippoFerreira.BusTicketsManagement.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter 
@Setter
public class BookRequestDTO {
    private long busTripId;
    private double totalDistance;
    private String paymentType;
    private int passengerCount;
    private int childrenCount;
    private int luggageCount;
    private double totalPrice;
    private int totalInstallments;
}
