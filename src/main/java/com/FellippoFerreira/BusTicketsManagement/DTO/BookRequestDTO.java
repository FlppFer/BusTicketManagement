package com.FellippoFerreira.BusTicketsManagement.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter 
@Setter
public class BookRequestDTO {
    private long busTripId;
    private String paymentType;
    private int totalInstallments;
    private int passengerCount;
    private int childrenCount;
    private int luggageCount;
}
