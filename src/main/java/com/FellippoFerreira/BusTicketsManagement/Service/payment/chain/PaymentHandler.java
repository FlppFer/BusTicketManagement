package com.FellippoFerreira.BusTicketsManagement.Service.payment.chain;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;

public interface PaymentHandler {
  void setNext(PaymentHandler nextHandler);

  void handle(BookedTripDTO bookedTripDTO);
}
