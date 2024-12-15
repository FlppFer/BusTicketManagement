package com.FellippoFerreira.BusTicketsManagement.Service;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;

public class PaymentService {
    private final float kmPrice = 15;

    public float calculateFinalPrice(BookRequestDTO bookRequest){
        int childrenCount = bookRequest.getChildrenCount();
        int adultCount = bookRequest.getPassengerCount() - childrenCount;
        float totalPrice = bookRequest.getTotalDistance() * kmPrice;
        applyChildrenDiscount(totalPrice);
        
        return _
    }

    private void applyChildrenDiscount(float price, int childrenCount){
        price = price - 
    }

    private void applyInterstateDiscount(float price){

    }
}
