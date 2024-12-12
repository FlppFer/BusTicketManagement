package com.FellippoFerreira.BusTicketsManagement.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/travel")
public class BusTicketsController {

  @GetMapping("/available")
  public ResponseEntity<> getAvailableTrips() {
  //  AvailableTripDTO busTripDTO =
    return ResponseEntity.ok().body(busTripDTO);
  }

  @GetMapping("/schedule")
  public ResponseEntity<?> scheduleTrip() {
    return ResponseEntity.status(HttpStatus.CREATED).body(ScheduledTripDTO);
  }

  @GetMapping("/checkMyTrips")
  public ResponseEntity<?> checkUserTrips() {
    return ResponseEntity.ok().body(busTripDTO);
  }

  @GetMapping("/cancel")
  public ResponseEntity<?> cancelScheduledTrip() {
    return ResponseEntity.noContent().build();
  }

}
