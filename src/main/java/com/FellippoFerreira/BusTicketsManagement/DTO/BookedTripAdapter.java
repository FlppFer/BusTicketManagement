package com.FellippoFerreira.BusTicketsManagement.DTO;

import com.FellippoFerreira.BusTicketsManagement.Model.BookedTripModel;
import java.awt.print.Book;

public class BookedTripAdapter {
    public static BookedTripDTO toDTO(BookedTripModel bookedTripModel) {
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

    public static BookedTripModel toModel(BookedTripDTO bookedTripDTO) {
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

    public static BookedTripDTO createDto(BookRequestDTO bookRequestDTO, AvailableTripDTO availableTripDTO) {
      BookedTripDTO bookedTripDTO = new BookedTripDTO();
      bookedTripDTO.setBusTripId(bookRequestDTO.getBusTripId());
      bookedTripDTO.setDepartureCity(availableTripDTO.getDepartureCity());
      bookedTripDTO.setDepartureState(availableTripDTO.getDepartureState());
      bookedTripDTO.setArrivalCity(availableTripDTO.getArrivalCity());
      bookedTripDTO.setArrivalState(availableTripDTO.getArrivalState());
      bookedTripDTO.setTotalDistance(availableTripDTO.getTotalDistance());
      bookedTripDTO.setDepartureDateTime(availableTripDTO.getDepartureDateTime());
      bookedTripDTO.setArrivalDateTime(availableTripDTO.getArrivalDateTime());
      bookedTripDTO.setTicketPrice(availableTripDTO.getTicketPrice());
      bookedTripDTO.setPaymentType(bookRequestDTO.getPaymentType());
      bookedTripDTO.setTotalInstallments(1);
      bookedTripDTO.setPassengerCount(bookRequestDTO.getPassengerCount());
      bookedTripDTO.setChildrenCount(bookRequestDTO.getChildrenCount());
      bookedTripDTO.setLuggageCount(bookRequestDTO.getLuggageCount());
      return bookedTripDTO;
    }

}
