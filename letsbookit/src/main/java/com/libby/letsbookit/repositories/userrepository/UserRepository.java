package com.libby.letsbookit.repositories.userrepository;

import com.libby.letsbookit.model.User.User;
import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends UserBaseRepository<User> {

}
