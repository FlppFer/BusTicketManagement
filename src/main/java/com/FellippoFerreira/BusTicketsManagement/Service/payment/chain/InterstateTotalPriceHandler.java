package com.FellippoFerreira.BusTicketsManagement.Service.payment.chain;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;

public class InterstateTotalPriceHandler extends BasePaymentHandler {

  @Override
  public void handle(BookedTripDTO bookedTripDTO) {
    final double interStatePrice = 12.0;
    bookedTripDTO.setTotalPrice((bookedTripDTO.getTotalDistance() * interStatePrice) * bookedTripDTO.getPassengerCount());
  }
}
