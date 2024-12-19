package com.FellippoFerreira.BusTicketsManagement.DTO;

import com.FellippoFerreira.BusTicketsManagement.Model.AvailableTripModel;

public class AvailableTripAdapter {
    public static AvailableTripDTO toDTO(AvailableTripModel availableTripModel) {
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
        return availableTripDTO;
    }
}
