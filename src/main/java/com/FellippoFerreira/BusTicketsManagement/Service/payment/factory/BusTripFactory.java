package com.FellippoFerreira.BusTicketsManagement.Service.payment.factory;

import com.FellippoFerreira.BusTicketsManagement.Service.repository.TripsRepository;
import org.springframework.stereotype.Service;

@Service
public class BusTripFactory {
  protected final TripsRepository tripsRepository;

  public BusTripFactory(TripsRepository tripsRepository) {
    this.tripsRepository = tripsRepository;
  }

  public Trip createBusTrip(String tripType) {
    if (tripType.equals("interstate")) {
      return new InterStateTrip(tripsRepository);
    } else {
      return new IntraStateTrip(tripsRepository);
    }
  }

}
