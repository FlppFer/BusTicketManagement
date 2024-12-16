package com.FellippoFerreira.BusTicketsManagement.Service.payment.chain;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;

public class IntrastateTotalPriceHandler extends BasePaymentHandler {

  @Override
  public void handle(BookedTripDTO bookedTripDTO) {
    final double intraStatePrice = 9.6;
    bookedTripDTO.setTotalPrice((bookedTripDTO.getTotalDistance() * intraStatePrice) * bookedTripDTO.getPassengerCount());
  }
}
