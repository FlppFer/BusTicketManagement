package com.FellippoFerreira.BusTicketsManagement.Service.payment;

import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;
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

    public void setTotalPrice(BookRequestDTO bookRequest){
        setTotalDistance(bookRequest);
        setPriceByTripType(bookRequest);
    }

    private void setTotalDistance(BookRequestDTO bookRequest){
        bookRequest.setTotalDistance(tripsRepository.getTotalTripDistance(bookRequest.getBusTripId()));
    }

    public void setPriceByTripType(BookRequestDTO bookRequest){
        if (tripsRepository.isInterstateTrip(bookRequest.getBusTripId())){
            InterstateChain(bookRequest);
        } else {
            IntrastateChain(bookRequest);
        }
    }

    private void InterstateChain(BookRequestDTO bookRequest){
        InterstateTotalPriceHandler interstateTotalPriceHandler = new InterstateTotalPriceHandler();
        InterstateChildrenDiscountHandler interstateChildrenDiscountHandler = new InterstateChildrenDiscountHandler();
        interstateTotalPriceHandler.setNext(interstateChildrenDiscountHandler);
        interstateTotalPriceHandler.handle(bookRequest);
    }

    private void IntrastateChain(BookRequestDTO bookRequest){
        IntrastateTotalPriceHandler intrastateTotalPriceHandler = new IntrastateTotalPriceHandler();
        IntrastateChildrenDiscountHandler intrastateChildrenDiscountHandler = new IntrastateChildrenDiscountHandler();
        intrastateTotalPriceHandler.setNext(intrastateChildrenDiscountHandler);
        intrastateTotalPriceHandler.handle(bookRequest);
    }
}
