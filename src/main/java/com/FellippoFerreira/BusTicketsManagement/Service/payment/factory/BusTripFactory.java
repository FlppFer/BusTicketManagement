package com.FellippoFerreira.BusTicketsManagement.Service.payment.factory;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;
import com.FellippoFerreira.BusTicketsManagement.Service.repository.TripsRepository;
import org.springframework.stereotype.Service;

@Service
public class BusTripFactory {
  protected final TripsRepository tripsRepository;

  public BusTripFactory(TripsRepository tripsRepository) {
    this.tripsRepository = tripsRepository;
  }

  public Trip createBusTrip(BookRequestDTO bookRequestDTO) {
    if (tripsRepository.isInterstateTrip(bookRequestDTO.getBusTripId())) {
      return new InterStateTrip(tripsRepository);
    } else {
      return new IntraStateTrip(tripsRepository);
    }
  }

}
