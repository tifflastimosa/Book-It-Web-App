package com.libby.letsbookit.controller;

import com.libby.letsbookit.model.Stand;
import com.libby.letsbookit.service.EventService;
import com.libby.letsbookit.service.StandService;
import com.libby.letsbookit.service.VendorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/stands")
public class StandController {

  // connect with the service layer
  @Autowired
  private StandService standService;
  private EventService eventService;
  private VendorService vendorService;

  // POST Request

  @PostMapping(value = "/create")
  public ResponseEntity<Integer> createStand(@PathVariable("id") Integer id,
                                            @RequestParam(value = "name") String name,
                                            @RequestParam(value = "notes") String notes,
                                            @RequestParam(value = "booked") Boolean booked,
                                            @RequestParam(value = "price") Float price,
                                            @RequestParam(value = "eventId") Integer eventId,
                                            @RequestParam(value = "vendorId", required = false) Integer vendorId) {
    try {
      return new ResponseEntity<>(this.standService.updateStand(id, name, notes, booked, price,
                                                                this.eventService.getById(eventId),
                                                                this.vendorService.findVendorById(vendorId)),
                                                                HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  // GET Requests

  @GetMapping
  public ResponseEntity<List<Stand>> getAllStands() {
    List<Stand> stands = this.standService.findAllStands();
    if (!stands.isEmpty()) {
      return new ResponseEntity<>(stands, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Stand> getStand(@PathVariable Integer id) {
    Stand stand = this.standService.findStandById(id);
    if (stand != null) {
      return new ResponseEntity<>(stand, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  // PUT Request

  @PutMapping(value = "/update/{id}")
  public ResponseEntity<Integer> updateStand(@PathVariable("id") Integer id,
      @RequestParam(value = "name") String name,
      @RequestParam(value = "notes") String notes,
      @RequestParam(value = "booked") Boolean booked,
      @RequestParam(value = "price") Float price,
      @RequestParam(value = "eventId") Integer eventId,
      @RequestParam(value = "vendorId", required = false) Integer vendorId) {
    try {
      return new ResponseEntity<>(this.standService.updateStand(id, name, notes, booked, price,
                                  this.eventService.getById(eventId),
                                  this.vendorService.findVendorById(vendorId)), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  // DELETE Request

  /**
   * Deletes a stand from the database when given an id.
   *
   * @param id the primary key, unique id of the stand.
   * @return Returns the HTTP status, if the request is good or bad.
   */
  @DeleteMapping(value = "/delete/{id}")
  public ResponseEntity<HttpStatus> deleteStand(@PathVariable("id") Integer id) {
    try {
      this.standService.deleteStand(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
      }
}
