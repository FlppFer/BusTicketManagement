package com.FellippoFerreira.BusTicketsManagement.Service;

import com.FellippoFerreira.BusTicketsManagement.DTO.AvailableTripDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;
import com.FellippoFerreira.BusTicketsManagement.Model.BookRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class TripsService {

  public AvailableTripDTO getAvailableTripByDestinationOrDeparture(String destination, String departure) {
    return null;
  }

  public BookedTripDTO bookTrip(BookRequestDTO bookRequest) {
    return null;
  }

  public BookedTripDTO getBookedTrip(String tripId) {
    return null;
  }

  public void cancelBooking(String tripId) {
  }
}
