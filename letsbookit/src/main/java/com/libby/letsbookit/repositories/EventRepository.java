package com.libby.letsbookit.repositories;

import com.libby.letsbookit.model.Event;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {

  @Query("SELECT e FROM Event e WHERE e.location=:location")
  List<Event> findEventByLocation(@PathVariable(value = "location") String location);
}
