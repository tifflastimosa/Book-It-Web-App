package com.libby.letsbookit.repositories;

import com.libby.letsbookit.model.Market;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for class Market Repository.
 */
@Repository
public interface MarketRepository extends CrudRepository<Market, Integer> {

}
