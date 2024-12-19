package com.FellippoFerreira.BusTicketsManagement.Service.payment.strategy;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;

public class Credit implements PaymentStrategy {
    @Override
    public String getPaymentType() {
        return "credit";
    }

    @Override
    public void applyDiscount(BookedTripDTO bookedTripDTO){
        //do nothing
    }
    @Override
    public void setTotalInstallments(BookedTripDTO bookedTripDTO){
        //do nothing
    }
}
