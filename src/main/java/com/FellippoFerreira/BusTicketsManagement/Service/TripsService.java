package com.FellippoFerreira.BusTicketsManagement.Service;

import com.FellippoFerreira.BusTicketsManagement.DTO.AvailableTripAdapter;
import com.FellippoFerreira.BusTicketsManagement.DTO.AvailableTripDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripAdapter;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.SavedTripDto;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.PaymentService;
import com.FellippoFerreira.BusTicketsManagement.Service.repository.BookingRepository;
import com.FellippoFerreira.BusTicketsManagement.Service.repository.TripsRepository;
import java.util.Random;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TripsService {
  private final TripsRepository tripsRepository;
  private final BookingRepository bookingRepository;
  private final PaymentService paymentService;

  public TripsService(
      TripsRepository tripsRepository,
      BookingRepository bookingRepository,
      PaymentService paymentService) {
    this.tripsRepository = tripsRepository;
    this.bookingRepository = bookingRepository;
    this.paymentService = paymentService;
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
    BookedTripDTO bookedTripDTO = createBookedTrip(bookRequest);
    paymentService.setTotalPrice(bookedTripDTO);
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

  private BookedTripDTO createBookedTrip(BookRequestDTO bookRequest) {
    AvailableTripDTO availableTripDTO =
        AvailableTripAdapter.toDTO(
            tripsRepository.getAvailableTripById(bookRequest.getBusTripId()));
    BookedTripDTO bookedTripDTO = BookedTripAdapter.createDto(bookRequest, availableTripDTO);
    bookedTripDTO.setTrackingCode(generateTrackingCode(availableTripDTO));
    return bookedTripDTO;
  }

  private String generateTrackingCode(AvailableTripDTO availableTripDTO) {
    return availableTripDTO.getDepartureState() + generateRandomString() + availableTripDTO.getArrivalState();
  }

  private String generateRandomString() {
    final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    final int ID_LENGTH = 4;
    final Random RANDOM = new Random();

    StringBuilder id = new StringBuilder(ID_LENGTH);
    for (int i = 0; i < ID_LENGTH; i++) {
      int index = RANDOM.nextInt(CHARACTERS.length());
      id.append(CHARACTERS.charAt(index));
    }
    return id.toString();
  }

}
