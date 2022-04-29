package com.libby.letsbookit.repositories.userrepository;

import com.libby.letsbookit.model.User.MarketStaff;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * Repository for subtype/child class, MarketStaffRepository.
 */
@Primary
@Repository
public interface MarketStaffRepository extends UserBaseRepository<MarketStaff> {

}
