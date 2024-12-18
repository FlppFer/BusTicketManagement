package com.FellippoFerreira.BusTicketsManagement.Service.payment.factory;

import com.FellippoFerreira.BusTicketsManagement.DTO.AvailableTripAdapter;
import com.FellippoFerreira.BusTicketsManagement.DTO.AvailableTripDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripAdapter;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;
import com.FellippoFerreira.BusTicketsManagement.Service.repository.TripsRepository;
import java.util.Random;

public abstract class Trip {
  protected final TripsRepository tripsRepository;

  protected Trip(TripsRepository tripsRepository) {
    this.tripsRepository = tripsRepository;
  }

  public BookedTripDTO createBookedTrip(BookRequestDTO bookRequest) {
    AvailableTripDTO availableTripDTO =
        AvailableTripAdapter.toDTO(
            tripsRepository.getAvailableTripById(bookRequest.getBusTripId()));
    BookedTripDTO bookedTripDTO = BookedTripAdapter.createDto(bookRequest, availableTripDTO);
    setTrackingCode(bookedTripDTO);
    setTotalPrice(bookedTripDTO);
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
}
