package com.FellippoFerreira.BusTicketsManagement.Service;

import com.FellippoFerreira.BusTicketsManagement.DTO.AvailableTripAdapter;
import com.FellippoFerreira.BusTicketsManagement.DTO.AvailableTripDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripAdapter;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.SavedTripDto;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.factory.BusTripFactory;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.factory.Trip;
import com.FellippoFerreira.BusTicketsManagement.Service.repository.BookingRepository;
import com.FellippoFerreira.BusTicketsManagement.Service.repository.TripsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TripsService {
  private final TripsRepository tripsRepository;
  private final BookingRepository bookingRepository;
  private final BusTripFactory busTripFactory;

  public TripsService(
      TripsRepository tripsRepository,
      BookingRepository bookingRepository, BusTripFactory busTripFactory) {
    this.tripsRepository = tripsRepository;
    this.bookingRepository = bookingRepository;
    this.busTripFactory = busTripFactory;
  }

  public AvailableTripDTO getAvailableTripByArrivalCity(String arrivalCity) {
    try{
    return AvailableTripAdapter.toDTO(
        tripsRepository.getAvailableTripByArrivalCity(arrivalCity));
    }catch (Exception e){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No trips available for this arrival city");
    }
  }

  public AvailableTripDTO getAvailableTripByDepartureCity(String departureCity) {
    try{
    return AvailableTripAdapter.toDTO(
        tripsRepository.getAvailableTripByDepartureCity(departureCity));
      }catch (Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No trips available for this departure city");
    }
  }

  public void cancelBooking(String trackingCode) {
    try{
    bookingRepository.deleteBookingByTrackingCode(trackingCode);}
    catch (Exception e){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot cancel booking");
    }
  }

  public BookedTripDTO getBookedTripByTrackingId(String trackingId) {
    try{
    return BookedTripAdapter.toDTO(bookingRepository.getBookedTripByTrackingCode(trackingId));}
    catch (Exception e){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No trips available for this tracking code");
    }
  }

  public SavedTripDto bookTrip(BookRequestDTO bookRequest) {
    Trip trip = busTripFactory.createBusTrip(bookRequest);
    BookedTripDTO bookedTripDTO = trip.createBookedTrip(bookRequest);
    try{
    bookingRepository.save(BookedTripAdapter.toModel(bookedTripDTO));}
    catch (Exception e){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot book trip");
    }
    return new SavedTripDto(
        bookedTripDTO.getTotalPrice(),
        bookedTripDTO.getTotalInstallments(),
        bookedTripDTO.getTrackingCode());
  }


}
