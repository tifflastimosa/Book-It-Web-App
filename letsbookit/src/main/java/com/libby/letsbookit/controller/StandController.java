package com.libby.letsbookit.controller;

import com.libby.letsbookit.model.Stand;
import com.libby.letsbookit.service.EventService;
import com.libby.letsbookit.service.StandService;
import com.libby.letsbookit.service.VendorService;
import java.util.List;
import javax.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @Autowired
  private EventService eventService;

  @Autowired
  private VendorService vendorService;

  // POST Request

  @PostMapping(value = "/add-stand")
  public ResponseEntity<Stand> addStand(@RequestBody Stand stand) {
    try {
      return new ResponseEntity<>(this.standService.addStand(stand), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  // GET Requests

  /**
   * Client request to get all stands from the stands table in the database.
   *
   * @return A list of all stands in the database.
   */
  @GetMapping(value = "/all")
  public ResponseEntity<List<Stand>> getAllStands() {
    List<Stand> stands = this.standService.getAllStands();
    if (!stands.isEmpty()) {
      return new ResponseEntity<>(stands, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  /**
   * Client request to get a stand given an id from the database.
   *
   * @param id The unique id/primary key of the stand.
   * @return The stand of the given id number.
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<Stand> getStand(@PathVariable Integer id) {
    Stand stand = this.standService.getStandyById(id);
    if (stand != null) {
      return new ResponseEntity<>(stand, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  // PUT Request

  /**
   * Client
   * @param id
   * @param stand
   * @return
   */
  @PutMapping(value = "/update/{id}")
  public ResponseEntity<Stand> updateStand(@PathVariable("id") @Positive Integer id,
                                           @RequestBody Stand stand) {
    try {
      return new ResponseEntity<>(this.standService.updateStand(id, stand), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  // DELETE Request

  /**
   * Client request to delete a stand from the database when given an id.
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
