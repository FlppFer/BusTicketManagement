package com.FellippoFerreira.BusTicketsManagement.Service.payment.chain;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;

public class IntrastateTotalPriceHandler extends BasePaymentHandler {

  @Override
  public void handle(BookRequestDTO bookRequest) {
    final double intraStatePrice = 9.6;
    bookRequest.setTotalPrice((bookRequest.getTotalDistance() * intraStatePrice) * bookRequest.getPassengerCount());
  }
}
