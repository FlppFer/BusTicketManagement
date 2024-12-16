package com.FellippoFerreira.BusTicketsManagement.Service.payment.chain;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;

public class InterstateTotalPriceHandler extends BasePaymentHandler {

  @Override
  public void handle(BookRequestDTO bookRequest) {
    final double interStatePrice = 12.0;
    bookRequest.setTotalPrice((bookRequest.getTotalDistance() * interStatePrice) * bookRequest.getPassengerCount());
  }
}
