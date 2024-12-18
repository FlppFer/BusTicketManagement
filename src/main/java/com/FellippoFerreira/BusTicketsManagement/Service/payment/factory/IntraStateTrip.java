package com.FellippoFerreira.BusTicketsManagement.Service.payment.factory;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.chain.IntrastateChildrenDiscountHandler;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.chain.IntrastateTotalPriceHandler;
import com.FellippoFerreira.BusTicketsManagement.Service.repository.TripsRepository;

public class IntraStateTrip extends Trip {

    public IntraStateTrip(TripsRepository tripsRepository){
        super(tripsRepository);
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
