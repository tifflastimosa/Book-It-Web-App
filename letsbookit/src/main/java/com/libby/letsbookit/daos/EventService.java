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

  public Integer createEvent(String name, String start, String end,
      String location, String venueLayout) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime startTimeObject = LocalDateTime.parse(start, formatter);
    LocalDateTime endTimeObject = LocalDateTime.parse(end, formatter);
    Event event = new Event(name, startTimeObject, endTimeObject, location, venueLayout);
    this.eventRepository.save(event);
    return event.getId();
  }


}
