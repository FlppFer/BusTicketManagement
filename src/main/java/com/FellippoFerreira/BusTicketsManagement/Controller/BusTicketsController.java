package com.FellippoFerreira.BusTicketsManagement.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/travel")
public class BusTicketsController {

  @GetMapping("/available")
  public ResponseEntity<?> getAvailableTrips() {
    return null;
  }

  @GetMapping("/schedule")
  public ResponseEntity<?> scheduleTrip() {
    return null;
  }

  @GetMapping("/checkMyTrips")
  public ResponseEntity<?> checkUserTrips() {
    return null;
  }

  @GetMapping("/cancel")
  public ResponseEntity<?> cancelScheduledTrip() {
    return null;
  }

}
