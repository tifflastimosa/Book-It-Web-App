package com.libby.letsbookit.service.userservice;

import com.libby.letsbookit.model.User.MarketStaff;
import com.libby.letsbookit.model.User.Roles;
import com.libby.letsbookit.model.User.User;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Interface for abstract class UserService to ensure that subtype classes that inherit from
 * UserService to use the required methods.
 */
@Component
public interface IUserService {



  /**
   * Provides the business logic to get all users from the database.
   *
   * @return A list of all users in the database.
   */
  List<User> getAll();

  /**
   * Provides the business logic to get a user from the database, when given the id, or primary
   * key, of the user.
   *
   * @param id the primary key, unique id of the user.
   * @return The user of the assigned id number.
   */
  User getById(Integer id);

  /**
   * Provides the business logic to delete a user from the database, when given the id, or primary
   * key of the user.
   *
   * @param id the primary key, unique id of the user.
   */
  void deleteUser(Integer id);

}
