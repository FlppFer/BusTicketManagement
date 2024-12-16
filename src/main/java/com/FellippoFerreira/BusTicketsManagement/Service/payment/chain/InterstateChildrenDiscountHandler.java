package com.FellippoFerreira.BusTicketsManagement.Service.payment.chain;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;

public class InterstateChildrenDiscountHandler extends BasePaymentHandler{
  @Override
  public void handle (BookedTripDTO bookedTripDTO){
    final double interStateDiscount = 0.1;
    double averageTicketPrice = bookedTripDTO.getTotalPrice() / bookedTripDTO.getPassengerCount();
    bookedTripDTO.setTotalPrice(bookedTripDTO.getTotalPrice() - (averageTicketPrice * bookedTripDTO.getChildrenCount() * interStateDiscount));
  }
}
