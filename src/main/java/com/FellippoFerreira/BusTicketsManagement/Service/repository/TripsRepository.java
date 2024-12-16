package com.FellippoFerreira.BusTicketsManagement.Service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TripsRepository {

  @Query(nativeQuery = true, value = "SELECT totalTripDistance FROM available_trips WHERE busTripId = busTripId")
  long getTotalTripDistance(@Param("busTripId") long busTripId);

  @Query(nativeQuery = true, value = "SELECT isInterState FROM available_trips WHERE busTripId = busTripId")
  boolean isInterstateTrip(@Param("busTripId") long busTripId);
}
