package com.FellippoFerreira.BusTicketsManagement.Service.payment.strategy;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;

public interface Payment {
    public void applyDiscount(BookedTripDTO bookedTripDTO);
    public void setTotalInstallments(BookedTripDTO bookedTripDTO);
}
