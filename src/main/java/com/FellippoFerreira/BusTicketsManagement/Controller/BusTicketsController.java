package com.FellippoFerreira.BusTicketsManagement.Controller;

import com.FellippoFerreira.BusTicketsManagement.DTO.AvailableTripDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookRequestDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.BookedTripDTO;
import com.FellippoFerreira.BusTicketsManagement.DTO.SavedTripDto;
import com.FellippoFerreira.BusTicketsManagement.Service.TripsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/travel")
public class BusTicketsController {

  private final TripsService tripsService;

  public BusTicketsController(TripsService tripsService) {
    this.tripsService = tripsService;
  }

  @GetMapping("/availableByArrivalCity")
  public ResponseEntity<AvailableTripDTO> getAvailableTripByArrivalCity(@RequestParam String arrivalCity) {
    AvailableTripDTO availableTripDTO = tripsService.getAvailableTripByArrivalCity(arrivalCity);
    return ResponseEntity.ok().body(availableTripDTO);
  }

  @GetMapping("/availableByDepartureCity")
  public ResponseEntity<AvailableTripDTO> getAvailableTripByDepartureCity(@RequestParam String departureCity) {
    return ResponseEntity.ok().body(tripsService.getAvailableTripByDepartureCity(departureCity));
  }

  @GetMapping("/bookTrip")
  public ResponseEntity<SavedTripDto> scheduleTrip(@RequestBody BookRequestDTO bookRequest) {
    return ResponseEntity.status(HttpStatus.CREATED).body(tripsService.bookTrip(bookRequest));
  }

  @GetMapping("/checkTripByCode")
  public ResponseEntity<BookedTripDTO> checkTripByTrackingCode(@RequestParam String trackingCode) {
    return ResponseEntity.ok().body(tripsService.getBookedTripByTrackingId(trackingCode));
  }

  @GetMapping("/cancel")
  public ResponseEntity<?> cancelScheduledTrip(@RequestParam String trackingCode) {
    tripsService.cancelBooking(trackingCode);
    return ResponseEntity.noContent().build();
  }

}
