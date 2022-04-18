package com.libby.letsbookit.repositories.userrepository;

import com.libby.letsbookit.model.User.Roles;
import com.libby.letsbookit.model.User.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends CrudRepository<T, Integer> {

}
