package com.libby.letsbookit.repositories.userrepository;

import com.libby.letsbookit.model.User.VendorStaff;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorStaffRepository extends UserBaseRepository<VendorStaff> {

}
