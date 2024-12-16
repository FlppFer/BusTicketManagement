package com.FellippoFerreira.BusTicketsManagement.Service.payment;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.chain.InterstateChildrenDiscountHandler;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.chain.InterstateTotalPriceHandler;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.chain.IntrastateChildrenDiscountHandler;
import com.FellippoFerreira.BusTicketsManagement.Service.payment.chain.IntrastateTotalPriceHandler;
import com.FellippoFerreira.BusTicketsManagement.Service.repository.TripsRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final TripsRepository tripsRepository;

    public PaymentService(TripsRepository tripsRepository){
        this.tripsRepository = tripsRepository;
    }

    public void setTotalPrice(BookedTripDTO bookedTripDTO){
        setPriceByTripType(bookedTripDTO);
    }

    private void setPriceByTripType(BookedTripDTO bookedTripDTO){
        if (tripsRepository.isInterstateTrip(bookedTripDTO.getBusTripId())){
            InterstateChain(bookedTripDTO);
        } else {
            IntrastateChain(bookedTripDTO);
        }
    }

    private void InterstateChain(BookedTripDTO bookedTripDTO){
        InterstateTotalPriceHandler interstateTotalPriceHandler = new InterstateTotalPriceHandler();
        InterstateChildrenDiscountHandler interstateChildrenDiscountHandler = new InterstateChildrenDiscountHandler();
        interstateTotalPriceHandler.setNext(interstateChildrenDiscountHandler);
        interstateTotalPriceHandler.handle(bookedTripDTO);
    }

    private void IntrastateChain(BookedTripDTO bookedTripDTO){
        IntrastateTotalPriceHandler intrastateTotalPriceHandler = new IntrastateTotalPriceHandler();
        IntrastateChildrenDiscountHandler intrastateChildrenDiscountHandler = new IntrastateChildrenDiscountHandler();
        intrastateTotalPriceHandler.setNext(intrastateChildrenDiscountHandler);
        intrastateTotalPriceHandler.handle(bookedTripDTO);
    }
}
