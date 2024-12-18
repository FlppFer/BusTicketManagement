package com.FellippoFerreira.BusTicketsManagement.Service.payment.factory;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.chain.InterstateChildrenDiscountHandler;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.chain.InterstateTotalPriceHandler;
import com.FellippoFerreira.BusTicketsManagement.Service.repository.TripsRepository;

public class InterStateTrip extends Trip {

  public InterStateTrip(TripsRepository tripsRepository){
    super(tripsRepository);
  }

  @Override
  public BookedTripDTO generateBookedTrip(BookRequestDTO bookRequest) {
    BookedTripDTO bookedTripDTO = createBookedTrip(bookRequest);
    setTotalPrice(bookedTripDTO);
    return bookedTripDTO;
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
