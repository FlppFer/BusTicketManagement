package com.FellippoFerreira.BusTicketsManagement.Service.payment.strategy;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;

public interface PaymentStrategy {
    String getPaymentType();
    void applyDiscount(BookedTripDTO bookedTripDTO);
    void setTotalInstallments(BookedTripDTO bookedTripDTO);
}
