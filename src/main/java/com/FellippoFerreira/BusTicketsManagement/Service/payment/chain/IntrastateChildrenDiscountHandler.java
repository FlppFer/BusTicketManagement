package com.FellippoFerreira.BusTicketsManagement.Service.payment.chain;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;

public class IntrastateChildrenDiscountHandler extends BasePaymentHandler{
  @Override
  public void handle (BookRequestDTO bookRequest){
    final double intraStateDiscount = 0.2;
    double averageTicketPrice = bookRequest.getTotalPrice() / bookRequest.getPassengerCount();
    bookRequest.setTotalPrice(bookRequest.getTotalPrice() - (averageTicketPrice * bookRequest.getChildrenCount() * intraStateDiscount));
  }
}
