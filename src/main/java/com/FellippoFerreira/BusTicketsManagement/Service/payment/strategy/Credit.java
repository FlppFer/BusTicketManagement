package com.FellippoFerreira.BusTicketsManagement.Service.payment.strategy;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;

public class Credit implements Payment {
    public double setTotalPrice(BookedTripDTO bookedTripDTO){
        return bookedTripDTO.getTotalPrice();
    }
    public int setTotalInstallments(BookedTripDTO bookedTripDTO){
        return bookedTripDTO.getTotalInstallments();
    }
}
