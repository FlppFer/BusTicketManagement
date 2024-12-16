package com.FellippoFerreira.BusTicketsManagement.Service;

import com.FellippoFerreira.BusTicketsManagement.DTO.AvailableTripDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;
import com.FellippoFerreira.BusTicketsManagement.Model.AvailableTripModel;
import com.FellippoFerreira.BusTicketsManagement.Service.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class TripsService {
  private final BookingRepository bookingRepository;

  public TripsService(BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
  }

  public AvailableTripDTO getAvailableTripByArrival(String arrivalCity) {
    return convertToDto(bookingRepository.getAvailableTripByArrivalCity(arrivalCity));
  }

  public AvailableTripDTO getAvailableTripByDeparture(String departureCity) {
    return convertToDto(bookingRepository.getAvailableTripByArrivalCity(departureCity));
  }

  public BookedTripDTO bookTrip(BookRequestDTO bookRequest) {

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
        availableTripModel.getMaxLuggagePerPassenger(),
        availableTripModel.isInterState()
    );
  }
}
