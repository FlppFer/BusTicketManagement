package com.FellippoFerreira.BusTicketsManagement.Service.payment.strategy;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;

public interface Payment {
    public double setTotalPrice(BookRequestDTO bookRequest);
    public int setTotalInstallments(BookRequestDTO bookRequest);
}
