package com.FellippoFerreira.BusTicketsManagement.Service.payment.factory;

import com.FellippoFerreira.BusTicketsManagement.DTO.AvailableTripAdapter;
import com.FellippoFerreira.BusTicketsManagement.DTO.AvailableTripDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripAdapter;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;
import com.FellippoFerreira.BusTicketsManagement.Service.repository.TripsRepository;

public abstract class Trip {
  protected final TripsRepository tripsRepository;

  protected Trip(TripsRepository tripsRepository) {
    this.tripsRepository = tripsRepository;
  }

  public abstract BookedTripDTO generateBookedTrip(BookRequestDTO bookRequest);

  abstract void setTotalPrice(BookedTripDTO bookedTripDTO);

  private String generateTrackingCode(BookedTripDTO bookedTripDTO) {
    return bookedTripDTO.getBusTripId() + "1234" + bookedTripDTO.getBusTripId();
  }

  protected BookedTripDTO createBookedTrip(BookRequestDTO bookRequest) {
    AvailableTripDTO availableTripDTO =
        AvailableTripAdapter.toDTO(
            tripsRepository.getAvailableTripById(bookRequest.getBusTripId()));
    BookedTripDTO bookedTripDTO = BookedTripAdapter.createDto(bookRequest, availableTripDTO);
    bookedTripDTO.setTrackingCode(generateTrackingCode(bookedTripDTO));
    return bookedTripDTO;
  }
}
