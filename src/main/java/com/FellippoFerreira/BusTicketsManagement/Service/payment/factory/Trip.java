package com.FellippoFerreira.BusTicketsManagement.Service.payment.factory;

import com.FellippoFerreira.BusTicketsManagement.DTO.AvailableTripAdapter;
import com.FellippoFerreira.BusTicketsManagement.DTO.AvailableTripDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripAdapter;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.strategy.PaymentStrategy;
import com.FellippoFerreira.BusTicketsManagement.Service.repository.TripsRepository;
import java.util.Random;
import java.util.Set;

public abstract class Trip {
  protected final TripsRepository tripsRepository;
  protected final Set<PaymentStrategy> strategies;

  protected Trip(TripsRepository tripsRepository, Set<PaymentStrategy> strategies) {
    this.tripsRepository = tripsRepository;
    this.strategies = strategies;
  }

  public BookedTripDTO createBookedTrip(BookRequestDTO bookRequest) {
    AvailableTripDTO availableTripDTO =
        AvailableTripAdapter.toDTO(
            tripsRepository.getAvailableTripById(bookRequest.getBusTripId()));
    BookedTripDTO bookedTripDTO = BookedTripAdapter.createDto(bookRequest, availableTripDTO);
    setTrackingCode(bookedTripDTO);
    setTotalPrice(bookedTripDTO);
    processPaymentType(bookedTripDTO);
    return bookedTripDTO;
  }

  abstract void setTotalPrice(BookedTripDTO bookedTripDTO);


  private void setTrackingCode(BookedTripDTO bookedTripDTO) {
    bookedTripDTO.setTrackingCode(bookedTripDTO.getDepartureCity() + generateRandom4DigitString() + bookedTripDTO.getArrivalCity());
  }

  private String generateRandom4DigitString() {
    final int length = 4;
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    StringBuilder result = new StringBuilder(length);
    Random random = new Random();

    for (int i = 0; i < length; i++) {
      int index = random.nextInt(characters.length());
      result.append(characters.charAt(index));
    }

    return result.toString();
  }

  private void processPaymentType(BookedTripDTO bookedTripDTO) {
    for (PaymentStrategy strategy : strategies) {
      if (strategy.getPaymentType().equals(bookedTripDTO.getPaymentType())) {
        strategy.applyDiscount(bookedTripDTO);
        strategy.setTotalInstallments(bookedTripDTO);
      }
    }
  }
}
