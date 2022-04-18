package com.libby.letsbookit.repositories.userrepository;

import com.libby.letsbookit.model.User.MarketStaff;
import org.springframework.stereotype.Repository;

/**
 * Repository for subtype/child class, MarketStaffRepository.
 */
@Repository
public interface MarketStaffRepository extends UserBaseRepository<MarketStaff> {

}
