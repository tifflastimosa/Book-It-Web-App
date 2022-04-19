package com.libby.letsbookit.daos;

import com.libby.letsbookit.model.Event;
import com.libby.letsbookit.repositories.userrepository.EventRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

  @Autowired
  private EventRepository eventRepository;

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
  @Override
  public Integer createEvent(String name, String start, String end,
      String location, String venueLayout) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime startTimeObject = LocalDateTime.parse(start, formatter);
    LocalDateTime endTimeObject = LocalDateTime.parse(end, formatter);
    Event event = new Event(name, startTimeObject, endTimeObject, location, venueLayout);
    this.eventRepository.save(event);
    return event.getId();
  }

  /**
   * Updates the event in the database.
   *
   * @param name The name of the event.
   * @param start The start time of the event.
   * @param end The end time of the event.
   * @param location The location of the event.
   * @param venueLayout The layout of the venue where the event will be held.
   * @return
   */
  @Override
  public Integer updateEvent(String name, String start, String end, String location,
      String venueLayout) {
    Event event = (Event) this.get

  }
      this.EventRepository.save();
      return event

}
