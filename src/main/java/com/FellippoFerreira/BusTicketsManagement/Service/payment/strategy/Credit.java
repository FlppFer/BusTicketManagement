package com.FellippoFerreira.BusTicketsManagement.Service.payment.strategy;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;

public class Credit implements Payment {
    public void applyDiscount(BookedTripDTO bookedTripDTO){
        //do nothing
    }
    public void setTotalInstallments(BookedTripDTO bookedTripDTO){
        //do nothing
    }
}
