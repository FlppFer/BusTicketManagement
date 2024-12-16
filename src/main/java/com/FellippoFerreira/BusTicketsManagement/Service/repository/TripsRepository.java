package com.FellippoFerreira.BusTicketsManagement.Service.repository;

import com.FellippoFerreira.BusTicketsManagement.DTO.AvailableTripDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;
import com.FellippoFerreira.BusTicketsManagement.Model.AvailableTripModel;
import com.FellippoFerreira.BusTicketsManagement.Model.BookedTripModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TripsRepository extends JpaRepository<AvailableTripModel, Long> {

  @Query(nativeQuery = true, value = "SELECT * FROM available_trips WHERE bus_trip_id = :busTripId")
  AvailableTripModel getAvailableTripById(@Param("busTripId") long busTripId);

  @Query(nativeQuery = true, value = "SELECT * FROM available_trips WHERE departure_city = :departureCity")
  AvailableTripModel getAvailableTripByDepartureCity(@Param("departureCity") String departureCity);

  @Query(nativeQuery = true, value = "SELECT * FROM available_trips WHERE arrival_city = :arrivalCity")
  AvailableTripModel getAvailableTripByArrivalCity(@Param("arrivalCity") String arrivalCity);

  @Query(nativeQuery = true, value = "SELECT total_trip_distance FROM available_trips WHERE bus_trip_id = :busTripId")
  long getTotalTripDistance(@Param("busTripId") long busTripId);

  @Query(nativeQuery = true, value = "SELECT is_inter_state FROM available_trips WHERE bus_trip_id = :busTripId")
  boolean isInterstateTrip(@Param("busTripId") long busTripId);
}
