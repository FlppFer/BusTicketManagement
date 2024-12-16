package com.FellippoFerreira.BusTicketsManagement.Service.payment.chain;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;

public class BasePaymentHandler implements PaymentHandler {
    private PaymentHandler nextHandler;

    @Override
    public void setNext(PaymentHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(BookRequestDTO bookRequest) {
        if (nextHandler != null) {
            nextHandler.handle(bookRequest);
        }
    }
}
