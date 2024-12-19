package com.FellippoFerreira.BusTicketsManagement.Service.payment.factory;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.chain.IntrastateChildrenDiscountHandler;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.chain.IntrastateTotalPriceHandler;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.strategy.PaymentStrategy;
import com.FellippoFerreira.BusTicketsManagement.Service.repository.TripsRepository;
import java.util.Set;

public class IntraStateTrip extends Trip {

    public IntraStateTrip(TripsRepository tripsRepository, Set<PaymentStrategy> strategies) {
        super(tripsRepository, strategies);
    }

  @Override
  public void setTotalPrice(BookedTripDTO bookedTripDTO) {
    IntrastateTotalPriceHandler intrastateTotalPriceHandler = new IntrastateTotalPriceHandler();
    IntrastateChildrenDiscountHandler intrastateChildrenDiscountHandler =
        new IntrastateChildrenDiscountHandler();
    intrastateTotalPriceHandler.setNext(intrastateChildrenDiscountHandler);
    intrastateTotalPriceHandler.handle(bookedTripDTO);

  }

}
