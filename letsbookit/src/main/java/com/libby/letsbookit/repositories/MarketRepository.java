package com.libby.letsbookit.repositories;

import com.libby.letsbookit.model.Event;
import com.libby.letsbookit.model.Market;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Repository for class Market Repository.
 */
@Repository
public interface MarketRepository extends JpaRepository<Market, Integer> {

  @Query("SELECT e FROM Event e WHERE e.location=:id ")
  List<Event> findAllEvents(@PathVariable(value = "id") Integer id);
}
