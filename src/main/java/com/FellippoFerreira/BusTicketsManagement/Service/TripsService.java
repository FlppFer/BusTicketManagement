package com.FellippoFerreira.BusTicketsManagement.Service;

import com.FellippoFerreira.BusTicketsManagement.DTO.AvailableTripDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;
import com.FellippoFerreira.BusTicketsManagement.Model.AvailableTripModel;
import com.FellippoFerreira.BusTicketsManagement.Model.BookRequestDTO;
import com.FellippoFerreira.BusTicketsManagement.Service.repository.TripsRepository;
import org.springframework.stereotype.Service;

@Service
public class TripsService {
  private final TripsRepository tripsRepository;

  public TripsService(TripsRepository tripsRepository) {
    this.tripsRepository = tripsRepository;
  }

  public AvailableTripDTO getAvailableTripByArrival(String arrivalCity) {
    return tripsRepository.getAvailableTripByArrivalCity(arrivalCity);
  }

  public AvailableTripDTO getAvailableTripByDeparture(String departureCity) {
    return tripsRepository.
  }

  public BookedTripDTO bookTrip(BookRequestDTO bookRequest) {
    return null;
  }

  public BookedTripDTO getBookedTrip(String tripId) {
    return null;
  }

  public void cancelBooking(String tripId) {
  }


  private AvailableTripDTO convertToDto(AvailableTripModel availableTripModel) {
    return new AvailableTripDTO(
        availableTripModel.getBusTripId(),
        availableTripModel.getDepartureCity(),
        availableTripModel.getDepartureState(),
        availableTripModel.getArrivalCity(),
        availableTripModel.getArrivalState(),
        availableTripModel.getTotalTripDistance(),
        availableTripModel.getDepartureDateTime(),
        availableTripModel.getArrivalDateTime(),
        availableTripModel.getTicketPrice(),
        availableTripModel.getAvailableSeats(),
        availableTripModel.getMaxLuggagePerPassenger()
    );
  }
}
