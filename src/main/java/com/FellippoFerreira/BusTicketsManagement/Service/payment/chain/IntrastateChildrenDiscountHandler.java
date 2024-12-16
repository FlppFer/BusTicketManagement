package com.FellippoFerreira.BusTicketsManagement.Service.payment.chain;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;

public class IntrastateChildrenDiscountHandler extends BasePaymentHandler{
  @Override
  public void handle (BookedTripDTO bookedTripDTO){
    final double intraStateDiscount = 0.2;
    double averageTicketPrice = bookedTripDTO.getTotalPrice() / bookedTripDTO.getPassengerCount();
    bookedTripDTO.setTotalPrice(bookedTripDTO.getTotalPrice() - (averageTicketPrice * bookedTripDTO.getChildrenCount() * intraStateDiscount));
  }
}
