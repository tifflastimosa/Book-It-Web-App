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
  public Event addEvent(Event event, Integer marketId) {
    Market market = this.marketRepository.getById(marketId);
    event.setMarket(market);
    return this.eventRepository.save(event);
  }

  /**
   * Provides the business logic to create an event object and then add it as a record to the
   * database.
   *
   * @param name The name of the event.
   * @param start The start time of the event.
   * @param end The end time of the event.
   * @param location The location of the event.
   * @param venueLayout The layout of the venue where the event will be held.
   * @return
   */
  public Integer associateEvent(Integer marketId, String name, String start, String end,
      String location, String venueLayout) throws Exception {
    LocalDateTime objectStart = this.helperDateConverter(start);
    LocalDateTime objectEnd = this.helperDateConverter(end);

    Event event = new Event(name, objectStart, objectEnd, location, venueLayout);

    Event eventRep =
        this.marketRepository
        .findById(marketId)
            .map(market -> {event.setMarket(market);
            return this.eventRepository.save(event);})
            .orElseThrow(() -> new Exception("Not found"));
    return event.getId();
  }

  public Integer createEventNoMarket(String name, String start, String end,
      String location, String venueLayout) {

    LocalDateTime objectStart = this.helperDateConverter(start);
    LocalDateTime objectEnd = this.helperDateConverter(end);

    Event event = new Event(name, objectStart, objectEnd, location, venueLayout);
    this.eventRepository.save(event);
    return event.getId();
  }

  public List<Event> getAll() {
    return (List<Event>) this.eventRepository.findAll();
  }

  public Event getById(Integer id) {
    Optional<Event> eventOptional = this.eventRepository.findById(id);
    Event eventObject = eventOptional.get();
    return eventObject;
  }

  public Integer updateEvent(Integer id, String name, String start, String end,
      String location, String venueLayout) {
    System.out.print("0");
    Event event = this.getById(id);
    System.out.print("1");
    event.setName(name);
    System.out.print("2");
    event.setStart(this.helperDateConverter(start));
    System.out.print("3");
    event.setEnd(this.helperDateConverter(end));
    System.out.print("4");
    event.setLocation(location);
    System.out.print("5");
    event.setVenueLayout(venueLayout);
    System.out.print("6");
    this.eventRepository.save(event);
    System.out.print("7");
    return event.getId();
  }

  public void deleteEvent(Integer id) {
    this.eventRepository.deleteById(id);
  }

  public List<Event> getEventByLocation(String location) {
   return this.eventRepository.findEventByLocation(location);

  }

}
