package com.libby.letsbookit.repositories.userrepository;

import com.libby.letsbookit.model.User.MarketStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * Repository for subtype/child class, MarketStaffRepository.
 */
@Repository
public interface MarketStaffRepository extends UserBaseRepository<MarketStaff> {

}
