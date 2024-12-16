package com.FellippoFerreira.BusTicketsManagement.Service;

import com.FellippoFerreira.BusTicketsManagement.DTO.AvailableTripDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.SavedTripDto;
import com.FellippoFerreira.BusTicketsManagement.Model.AvailableTripModel;
import com.FellippoFerreira.BusTicketsManagement.Model.BookedTripModel;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.PaymentService;
import com.FellippoFerreira.BusTicketsManagement.Service.repository.BookingRepository;
import com.FellippoFerreira.BusTicketsManagement.Service.repository.TripsRepository;
import java.util.Random;
import org.springframework.stereotype.Service;

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
    return convertAvailableTripModelToDto(
        tripsRepository.getAvailableTripByArrivalCity(arrivalCity));
  }

  public AvailableTripDTO getAvailableTripByDepartureCity(String departureCity) {
    return convertAvailableTripModelToDto(
        tripsRepository.getAvailableTripByDepartureCity(departureCity));
  }

  public void cancelBooking(String trackingCode) {
    bookingRepository.deleteBookingByTrackingCode(trackingCode);
  }

  public BookedTripDTO getBookedTripByTrackingId(String trackingId) {
    return converBookedTripModelToDto(bookingRepository.getBookedTripByTrackingCode(trackingId));
  }

  public SavedTripDto bookTrip(BookRequestDTO bookRequest) {
    BookedTripDTO bookedTripDTO = createBookedTrip(bookRequest);
    paymentService.setTotalPrice(bookedTripDTO);
    bookingRepository.save(converBookedTripDtoToModel(bookedTripDTO));
    return new SavedTripDto(
        bookedTripDTO.getTotalPrice(),
        bookedTripDTO.getTotalInstallments(),
        bookedTripDTO.getTrackingCode());
  }

  private BookedTripDTO createBookedTrip(BookRequestDTO bookRequest) {
    AvailableTripDTO availableTripDTO =
        convertAvailableTripModelToDto(
            tripsRepository.getAvailableTripById(bookRequest.getBusTripId()));
    BookedTripDTO bookedTripDTO = new BookedTripDTO();
    bookedTripDTO.setBusTripId(bookRequest.getBusTripId());
    bookedTripDTO.setDepartureCity(availableTripDTO.getDepartureCity());
    bookedTripDTO.setDepartureState(availableTripDTO.getDepartureState());
    bookedTripDTO.setArrivalCity(availableTripDTO.getArrivalCity());
    bookedTripDTO.setArrivalState(availableTripDTO.getArrivalState());
    bookedTripDTO.setTotalDistance(availableTripDTO.getTotalDistance());
    bookedTripDTO.setDepartureDateTime(availableTripDTO.getDepartureDateTime());
    bookedTripDTO.setArrivalDateTime(availableTripDTO.getArrivalDateTime());
    bookedTripDTO.setTicketPrice(availableTripDTO.getTicketPrice());
    bookedTripDTO.setPaymentType(bookRequest.getPaymentType());
    bookedTripDTO.setTotalInstallments(1);
    bookedTripDTO.setPassengerCount(bookRequest.getPassengerCount());
    bookedTripDTO.setChildrenCount(bookRequest.getChildrenCount());
    bookedTripDTO.setLuggageCount(bookRequest.getLuggageCount());
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

  private BookedTripModel converBookedTripDtoToModel(BookedTripDTO bookedTripDTO) {
    BookedTripModel bookedTripModel = new BookedTripModel();
    bookedTripModel.setTrackingCode(bookedTripDTO.getTrackingCode());
    bookedTripModel.setBusTripId(bookedTripDTO.getBusTripId());
    bookedTripModel.setDepartureCity(bookedTripDTO.getDepartureCity());
    bookedTripModel.setDepartureState(bookedTripDTO.getDepartureState());
    bookedTripModel.setArrivalCity(bookedTripDTO.getArrivalCity());
    bookedTripModel.setArrivalState(bookedTripDTO.getArrivalState());
    bookedTripModel.setTotalDistance(bookedTripDTO.getTotalDistance());
    bookedTripModel.setDepartureDateTime(bookedTripDTO.getDepartureDateTime());
    bookedTripModel.setArrivalDateTime(bookedTripDTO.getArrivalDateTime());
    bookedTripModel.setTicketPrice(bookedTripDTO.getTicketPrice());
    bookedTripModel.setPaymentType(bookedTripDTO.getPaymentType());
    bookedTripModel.setTotalInstallments(bookedTripDTO.getTotalInstallments());
    bookedTripModel.setPassengerCount(bookedTripDTO.getPassengerCount());
    bookedTripModel.setChildrenCount(bookedTripDTO.getChildrenCount());
    bookedTripModel.setTotalPrice(bookedTripDTO.getTotalPrice());
    bookedTripModel.setLuggageCount(bookedTripDTO.getLuggageCount());
    return bookedTripModel;
  }

  private BookedTripDTO converBookedTripModelToDto(BookedTripModel bookedTripModel) {
    BookedTripDTO bookedTripDTO = new BookedTripDTO();
    bookedTripDTO.setTrackingCode(bookedTripModel.getTrackingCode());
    bookedTripDTO.setBusTripId(bookedTripModel.getBusTripId());
    bookedTripDTO.setDepartureCity(bookedTripModel.getDepartureCity());
    bookedTripDTO.setDepartureState(bookedTripModel.getDepartureState());
    bookedTripDTO.setArrivalCity(bookedTripModel.getArrivalCity());
    bookedTripDTO.setArrivalState(bookedTripModel.getArrivalState());
    bookedTripDTO.setTotalDistance(bookedTripModel.getTotalDistance());
    bookedTripDTO.setDepartureDateTime(bookedTripModel.getDepartureDateTime());
    bookedTripDTO.setArrivalDateTime(bookedTripModel.getArrivalDateTime());
    bookedTripDTO.setTicketPrice(bookedTripModel.getTicketPrice());
    bookedTripDTO.setPaymentType(bookedTripModel.getPaymentType());
    bookedTripDTO.setTotalInstallments(bookedTripModel.getTotalInstallments());
    bookedTripDTO.setPassengerCount(bookedTripModel.getPassengerCount());
    bookedTripDTO.setChildrenCount(bookedTripModel.getChildrenCount());
    bookedTripDTO.setTotalPrice(bookedTripModel.getTotalPrice());
    bookedTripDTO.setLuggageCount(bookedTripModel.getLuggageCount());
    return bookedTripDTO;
  }

  private AvailableTripDTO convertAvailableTripModelToDto(AvailableTripModel availableTripModel) {
    AvailableTripDTO availableTripDTO = new AvailableTripDTO();
    availableTripDTO.setBusTripId(availableTripModel.getBusTripId());
    availableTripDTO.setDepartureCity(availableTripModel.getDepartureCity());
    availableTripDTO.setDepartureState(availableTripModel.getDepartureState());
    availableTripDTO.setArrivalCity(availableTripModel.getArrivalCity());
    availableTripDTO.setArrivalState(availableTripModel.getArrivalState());
    availableTripDTO.setTotalDistance(availableTripModel.getTotalDistance());
    availableTripDTO.setDepartureDateTime(availableTripModel.getDepartureDateTime());
    availableTripDTO.setArrivalDateTime(availableTripModel.getArrivalDateTime());
    availableTripDTO.setTicketPrice(availableTripModel.getTicketPrice());
    availableTripDTO.setAvailableSeats(availableTripModel.getAvailableSeats());
    availableTripDTO.setMaxLuggagePerPassenger(availableTripModel.getMaxLuggagePerPassenger());
    availableTripDTO.setInterState(availableTripModel.isInterState());
    return availableTripDTO;
  }
}
