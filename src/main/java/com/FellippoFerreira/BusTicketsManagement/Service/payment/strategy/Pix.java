package com.FellippoFerreira.BusTicketsManagement.Service.payment.strategy;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;

public class Pix implements Payment {
    public double setTotalPrice(BookedTripDTO bookedTripDTO){
        return bookedTripDTO.getTotalPrice() * 0.95;
    }
    public int setTotalInstallments(BookedTripDTO bookedTripDTO){
        return 1;
    }
}
