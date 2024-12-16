package com.FellippoFerreira.BusTicketsManagement.Service.payment.chain;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;

public class BasePaymentHandler implements PaymentHandler {
    private PaymentHandler nextHandler;

    @Override
    public void setNext(PaymentHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(BookedTripDTO bookedTripDTO) {
        if (nextHandler != null) {
            nextHandler.handle(bookedTripDTO);
        }
    }
}
