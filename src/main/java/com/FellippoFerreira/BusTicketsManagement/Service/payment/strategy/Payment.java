package com.FellippoFerreira.BusTicketsManagement.Service.payment.strategy;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;

public interface Payment {
    public double setTotalPrice(BookedTripDTO bookedTripDTO);
    public int setTotalInstallments(BookedTripDTO bookedTripDTO);
}
