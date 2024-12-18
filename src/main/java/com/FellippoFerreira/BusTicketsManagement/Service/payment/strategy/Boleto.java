package com.FellippoFerreira.BusTicketsManagement.Service.payment.strategy;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;

public class Boleto implements Payment {
    public void applyDiscount(BookedTripDTO bookedTripDTO){
        //do nothing
    }
    public void setTotalInstallments(BookedTripDTO bookedTripDTO){
        bookedTripDTO.setTotalInstallments(1);
    }
}
