package com.FellippoFerreira.BusTicketsManagement.Service.payment.strategy;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;

public class Pix implements PaymentStrategy {

    @Override
    public String getPaymentType() {
        return "pix";
    }

    @Override
    public void applyDiscount(BookedTripDTO bookedTripDTO){
        bookedTripDTO.setTotalPrice(bookedTripDTO.getTotalPrice() * 0.95);
    }
    @Override
    public void setTotalInstallments(BookedTripDTO bookedTripDTO){
        bookedTripDTO.setTotalInstallments(1);
    }
}
