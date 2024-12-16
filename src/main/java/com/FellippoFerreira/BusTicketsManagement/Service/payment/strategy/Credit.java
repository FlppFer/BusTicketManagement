package com.FellippoFerreira.BusTicketsManagement.Service.payment.strategy;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;

public class Credit implements Payment {
    public double setTotalPrice(BookRequestDTO bookRequest){
        return bookRequest.getTotalPrice();
    }
    public int setTotalInstallments(BookRequestDTO bookRequest){
        return bookRequest.getTotalInstallments();
    }
}
