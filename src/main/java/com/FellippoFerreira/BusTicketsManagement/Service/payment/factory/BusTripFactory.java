package com.FellippoFerreira.BusTicketsManagement.Service.payment.factory;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.strategy.PaymentStrategy;
import com.FellippoFerreira.BusTicketsManagement.Service.repository.TripsRepository;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class BusTripFactory {
  protected final TripsRepository tripsRepository;
  protected final Set<PaymentStrategy> strategies;

  public BusTripFactory(TripsRepository tripsRepository, Set<PaymentStrategy> strategies) {
    this.tripsRepository = tripsRepository;
    this.strategies = strategies;
  }

  public Trip createBusTrip(BookRequestDTO bookRequestDTO) {
    if (tripsRepository.isInterstateTrip(bookRequestDTO.getBusTripId())) {
      return new InterStateTrip(tripsRepository, strategies);
    } else {
      return new IntraStateTrip(tripsRepository, strategies);
    }
  }

}
