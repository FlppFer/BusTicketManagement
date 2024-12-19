package com.FellippoFerreira.BusTicketsManagement.Service.payment.factory;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.chain.InterstateChildrenDiscountHandler;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.chain.InterstateTotalPriceHandler;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.strategy.PaymentStrategy;
import com.FellippoFerreira.BusTicketsManagement.Service.repository.TripsRepository;
import java.util.Set;

public class InterStateTrip extends Trip {

  public InterStateTrip(TripsRepository tripsRepository, Set<PaymentStrategy> strategies) {
    super(tripsRepository, strategies);
  }

  @Override
  public void setTotalPrice(BookedTripDTO bookedTripDTO) {
    InterstateTotalPriceHandler interstateTotalPriceHandler = new InterstateTotalPriceHandler();
    InterstateChildrenDiscountHandler interstateChildrenDiscountHandler =
        new InterstateChildrenDiscountHandler();
    interstateTotalPriceHandler.setNext(interstateChildrenDiscountHandler);
    interstateTotalPriceHandler.handle(bookedTripDTO);
  }

}
