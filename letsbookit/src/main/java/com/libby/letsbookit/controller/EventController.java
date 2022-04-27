package com.libby.letsbookit.controller;

import com.libby.letsbookit.service.EventService;
import com.libby.letsbookit.model.Event;
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

/**
 * EventController class provides CRUD requests for the client and updates the view as data changes.
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/events")
public class EventController{

  // connect with the service layer
  @Autowired
  private EventService eventService;

  // POST requests
  /**
   * Allows the client to request to create an Event that will be added to the database.
   *
   * @param name the name of the event.
   * @param start the start time of the event.
   * @param end the end time of the event.
   * @param location the location of the event.
   * @param venueLayout the layout of the venue where the event will be held.
   * @return Returns HTTP status, if the request is good or bad, and also returns the id.
   */
  @PostMapping(value = "/create")
  public ResponseEntity<Integer> createEvent(@RequestParam(value = "name") String name,
                                             @RequestParam(value = "start") String start,
                                             @RequestParam(value = "end") String end,
                                             @RequestParam(value = "location") String location,
                                             @RequestParam(value = "venueLayout") String venueLayout) {
    try {
      return new ResponseEntity<>(
          this.eventService.createEventNoMarket(name, start, end, location, venueLayout), HttpStatus.OK);
      } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    }

    @PostMapping(value = "/create/{marketId}")
    public ResponseEntity<Integer> associateMarketToEvent(
                                                          @PathVariable(value = "marketId", required = false) Integer marketId,
                                                          @RequestParam(value = "name") String name,
                                                          @RequestParam(value = "start") String start,
                                                          @RequestParam(value = "end") String end,
                                                          @RequestParam(value = "location") String location,
                                                          @RequestParam(value = "venueLayout") String venueLayout) {
      try {
        return new ResponseEntity<>(this.eventService.associateEvent(marketId,
                                                                     name,
                                                                     start,
                                                                     end,
                                                                     location,
                                                                     venueLayout), HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    }
  // GET requests

  /**
   * Gets all events from the database.
   *
   * @return Returns HTTP status, if the request is good or bad, and also returns a list of all
   * events in the database.
   */
  @GetMapping
  public ResponseEntity<List<Event>> getAllEvents() {
    List<Event> events = this.eventService.getAll();
    if (!events.isEmpty()) {
      return new ResponseEntity<>(events, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  /**
   * Gets an event from the database when given an id.
   *
   * @param id the autogenerated id of an event.
   * @return Returns HTTP status, if the request is good or bad, and also returns a list of all
   * events in the database.
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<Event> getEvent(@PathVariable Integer id) {
    Event event = this.eventService.getById(id);
    if (event != null) {
      return new ResponseEntity<>(event, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }


  // PUT (update) Request

  /**
   * Updates an event in the database when given an id.
   *
   * @param name the name of the event.
   * @param start the start time of the event.
   * @param end the end time of the event.
   * @param location the location of the event.
   * @param venueLayout the layout of the venue where the event will be held.
   * @return Returns HTTP status, if the request is good or bad, and also returns the id.
   */
  @PutMapping(value = "/update/{id}")
  public ResponseEntity<Integer> updateEvent(@PathVariable(value = "id") Integer id,
                                             @RequestParam(value = "name") String name,
                                             @RequestParam(value = "start") String start,
                                             @RequestParam(value = "end") String end,
                                             @RequestParam(value = "location") String location,
                                             @RequestParam(value = "venueLayout") String venueLayout) {

    System.out.println("A");
    try {
      System.out.println("B");
      return new ResponseEntity<>(this.eventService.updateEvent(id, name, start, end, location,
          venueLayout), HttpStatus.OK);
    } catch (Exception e) {
      System.out.println("C");
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  // DELETE Request

  /**
   * Deletes an event from the database when given an id.
   *
   * @param id the primary key, unique id of the event.
   * @return Returns HTTP status, if the request is good or bad.
   */
  @DeleteMapping(value = "/delete/{id}")
  public ResponseEntity<HttpStatus> deleteEvent(@PathVariable("id") Integer id) {
    try {
      this.eventService.deleteEvent(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(value = "/find/{location}")
  public ResponseEntity<List<Event>> findEventByLocation(@PathVariable(value = "location") String location) {
    try {
      return new ResponseEntity<>(
          this.eventService.getEventByLocation(location), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
