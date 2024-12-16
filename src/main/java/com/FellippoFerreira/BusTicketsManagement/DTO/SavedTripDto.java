package com.FellippoFerreira.BusTicketsManagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SavedTripDto {
  private double totalPrice;
  private int totalInstallments;
  private String trackingCode;
}
