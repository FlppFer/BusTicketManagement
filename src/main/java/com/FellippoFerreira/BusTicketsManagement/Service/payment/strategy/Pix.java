package com.FellippoFerreira.BusTicketsManagement.Service.payment.strategy;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;

public class Pix implements Payment {
    public void applyDiscount(BookedTripDTO bookedTripDTO){
        bookedTripDTO.setTotalPrice(bookedTripDTO.getTotalPrice() * 0.95);
    }
    public void setTotalInstallments(BookedTripDTO bookedTripDTO){
        bookedTripDTO.setTotalInstallments(1);
    }
}
