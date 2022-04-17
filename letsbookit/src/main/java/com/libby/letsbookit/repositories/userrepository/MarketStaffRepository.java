package com.libby.letsbookit.repositories.userrepository;

import com.libby.letsbookit.model.User.MarketStaff;
import javax.transaction.Transactional;

@Transactional
public interface MarketStaffRepository extends UserBaseRepository<MarketStaff> {



}
