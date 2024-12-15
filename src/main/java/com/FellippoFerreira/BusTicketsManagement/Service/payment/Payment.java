package com.FellippoFerreira.BusTicketsManagement.Service.payment;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;

public interface Payment {
    public float getTotalPrice(BookRequestDTO bookRequest);
    public int getTotalInstallments(BookRequestDTO bookRequest);
}
