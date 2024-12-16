package com.FellippoFerreira.BusTicketsManagement.Service.payment.chain;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;

public class InterstateChildrenDiscountHandler extends BasePaymentHandler{
  @Override
  public void handle (BookRequestDTO bookRequest){
    final double interStateDiscount = 0.1;
    double averageTicketPrice = bookRequest.getTotalPrice() / bookRequest.getPassengerCount();
    bookRequest.setTotalPrice(bookRequest.getTotalPrice() - (averageTicketPrice * bookRequest.getChildrenCount() * interStateDiscount));
  }
}
