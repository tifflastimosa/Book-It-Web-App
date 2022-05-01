package com.libby.letsbookit.service;

import com.libby.letsbookit.model.Event;
import com.libby.letsbookit.model.Market;
import com.libby.letsbookit.repositories.EventRepository;
import com.libby.letsbookit.repositories.MarketRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

  @Autowired
  private EventRepository eventRepository;

  @Autowired
  private MarketRepository marketRepository;

  private LocalDateTime helperDateConverter(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return LocalDateTime.parse(date,formatter);
  }

  // POST request

  /**
   * Adds an event created by the client to the database.
   *
   * @param event The event to be added to the database.
   * @param marketId The market id that the event will be associated with since an event cannot
   *                 exist without a market object.
   * @return The event object added to the database.
   */
  public Event addEvent(Event event, Integer marketId) {
    Market market = this.marketRepository.getById(marketId);
    event.setMarket(market);
    return this.eventRepository.save(event);
  }

  // GET requests

  /**
   * Retrieves all the Events from the database.
   *
   * @return A list of all Events saved in the database.
   */
  public List<Event> getAll() {
    return (List<Event>) this.eventRepository.findAll();
  }

  public Event getById(Integer id) {
    Optional<Event> eventOptional = this.eventRepository.findById(id);
    Event eventObject = eventOptional.get();
    return eventObject;
  }

  /**
   * Retrieves all events given a location from the database.
   *
   * @param location The location of the event.
   * @return A list of all Events when given a location. Filters the events by location.
   */
  public List<Event> getEventByLocation(String location) {
    return this.eventRepository.findEventByLocation(location);

  }

  // PUT request

  /**
   * Retrieves the Event with the given id from the database and updates the Event record with
   * the provided event object.
   *
   * @param id The unique id, primary key of the Event object to be updated.
   * @param event The event object to be updated.
   * @return The Event object with the updated information.
   */
  public Event updateEvent(Integer id, Event event) {
    Event fromDB = this.getById(id);
    fromDB.setName(event.getName());
    fromDB.setStart(event.getStart());
    fromDB.setEnd(event.getEnd());
    fromDB.setLocation(event.getLocation());
    fromDB.setVenueLayout(event.getVenueLayout());
    return this.eventRepository.save(fromDB);
  }

  // DELETE request
  /**
   * Deletes an Event record from the database.
   *
   * @param id The unique id, primary key of the Event object to be deleted from the database.
   */
  public void deleteEvent(Integer id) {
    this.eventRepository.deleteById(id);
  }

}
