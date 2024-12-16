package com.FellippoFerreira.BusTicketsManagement.Service.repository;

import com.FellippoFerreira.BusTicketsManagement.Model.BookedTripModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookingRepository extends JpaRepository<BookedTripModel, Long> {

  @Query(nativeQuery = true, value = "SELECT * FROM booked_trips WHERE tracking_code = :trackingCode")
  BookedTripModel getBookedTripByTrackingCode(@Param("trackingCode") String trackingCode);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "DELETE FROM booked_trips WHERE tracking_code = :trackingCode")
  void deleteBookingByTrackingCode(@Param("trackingCode") String trackingCode);
}
