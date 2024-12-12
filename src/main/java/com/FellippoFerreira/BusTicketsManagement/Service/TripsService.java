package com.FellippoFerreira.BusTicketsManagement.Service;

import com.FellippoFerreira.BusTicketsManagement.DTO.AvailableTripDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.TripToBeScheduledDTO;
import org.springframework.stereotype.Service;

@Service
public class TripsService {

  public AvailableTripDTO getAvailableTripByDestinationOrDeparture(String destination, String departure) {
    return null;
  }

  public BookedTripDTO scheduleTrip(TripToBeScheduledDTO tripToBeScheduledDTO) {
    return null;
  }

  public BookedTripDTO getActiveTrip(String tripId) {
    return null;
  }

  public void cancelTrip(String tripId) {
  }
}
