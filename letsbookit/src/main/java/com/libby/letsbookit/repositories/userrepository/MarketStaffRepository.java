package com.libby.letsbookit.repositories.userrepository;

import com.libby.letsbookit.model.User.MarketStaff;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketStaffRepository extends UserBaseRepository<MarketStaff> {



}
