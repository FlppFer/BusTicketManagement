package com.FellippoFerreira.BusTicketsManagement.Service.repository;

import com.FellippoFerreira.BusTicketsManagement.Model.AvailableTripModel;
import com.FellippoFerreira.BusTicketsManagement.Model.BookedTripModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TripsRepository {

  @Query(nativeQuery = true, value = "SELECT * FROM available_trips WHERE departureCity = departureCity")
  AvailableTripModel getAvailableTripByDepartureCity(@Param("departureCity") String departureCity);

  @Query(nativeQuery = true, value = "SELECT * FROM available_trips WHERE arrivalCity = arrivalCity")
  AvailableTripModel getAvailableTripByArrivalCity(@Param("arrivalCity") String arrivalCity);

  @Query(nativeQuery = true, value = "SELECT * FROM booked_trips WHERE busTripId = :id")
  BookedTripModel getBookedTripByTrackingId(@Param("id") Long busTripId);

  @Query(nativeQuery = true, value = "DELETE FROM booked_trips WHERE busTripId = :id;")
  void deleteBookingByTrackingId(@Param("id") Long busTripId);
}
