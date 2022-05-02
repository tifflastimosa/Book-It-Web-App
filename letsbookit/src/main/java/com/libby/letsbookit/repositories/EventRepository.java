package com.libby.letsbookit.repositories;

import com.libby.letsbookit.model.Event;
import com.libby.letsbookit.model.Stand;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Repository for events table modeled by Event class.
 */
@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {

  /**
   * Method gets all events when a location.
   *
   * @param location The location of the Event.
   * @return A list of all givens at a given location.
   */
  @Query("SELECT e FROM Event e WHERE e.location=:location")
  List<Event> findEventByLocation(@PathVariable(value = "location") String location);

}
