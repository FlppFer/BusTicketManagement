package com.FellippoFerreira.BusTicketsManagement.Service.payment.strategy;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;

public class Pix implements Payment {
    public double setTotalPrice(BookRequestDTO bookRequest){
        return bookRequest.getTotalPrice() * 0.95;
    }
    public int setTotalInstallments(BookRequestDTO bookRequest){
        return 1;
    }
}
