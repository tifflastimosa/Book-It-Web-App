package com.libby.letsbookit.repositories.userrepository;

import com.libby.letsbookit.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Repository for super/parent class UserBaseRepository.
 *
 * @param <T> A subtype class that inherits from User.
 */
@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends JpaRepository<T, Integer> {

}
