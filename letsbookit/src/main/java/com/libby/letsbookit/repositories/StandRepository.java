package com.libby.letsbookit.repositories;

import com.libby.letsbookit.model.Stand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for class Stand Repository.
 */
@Repository
public interface StandRepository extends CrudRepository<Stand, Integer> {

}
