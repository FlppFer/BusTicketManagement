package com.FellippoFerreira.BusTicketsManagement.Service.payment.strategy;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;

public class Boleto implements PaymentStrategy {
    @Override
    public String getPaymentType() {
        return "boleto";
    }

    @Override
    public void applyDiscount(BookedTripDTO bookedTripDTO){
        //do nothing
    }
    @Override
    public void setTotalInstallments(BookedTripDTO bookedTripDTO){
        bookedTripDTO.setTotalInstallments(1);
    }
}
