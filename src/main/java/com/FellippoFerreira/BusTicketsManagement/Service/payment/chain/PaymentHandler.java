package com.FellippoFerreira.BusTicketsManagement.Service.payment.chain;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;

public interface PaymentHandler {
  void setNext(PaymentHandler nextHandler);

  void handle(BookRequestDTO bookRequest);
}
