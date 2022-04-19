package com.libby.letsbookit.repositories.userrepository;

import com.libby.letsbookit.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event,Integer> {

}
