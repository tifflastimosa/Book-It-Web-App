package com.libby.letsbookit.service.userservice;

import com.libby.letsbookit.model.User.User;
import com.libby.letsbookit.repositories.userrepository.UserBaseRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * An abstract super class for all User types.
 *
 * @param <T> A subtype class that inherits from user.
 */
@Service
public abstract class UserService<T extends User> implements IUserService {

  // connects to the repository
  @Autowired
  private UserBaseRepository userRepository;

  /**
   * Helper function available to classes within the userservice package. Converts the
   * string to a LocalDateTime object.
   *
   * @param date A date in the format yyyy-MM-dd HH:mm.
   * @return A LocalDateObject equal to the param.
   */
  protected LocalDateTime helperLocalDateTime(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return LocalDateTime.parse(date,formatter);
  }

  /**
   * Provides the business logic to get all users from the database.
   *
   * @return A list of all users in the database.
   */
  @Override
  public List<User> getAll() {
    return (List<User>) this.userRepository.findAll();
  }

  /**
   * Helper function that gets the user from the database when given an id.
   *
   * @param id the primary key, unique id of the user.
   * @return The user of the assigned id number.
   */
  private User getUser(Integer id) {
    Optional<User> userOptional = this.userRepository.findById(id);
    return userOptional.get();
  }

  /**
   * Provides the business logic to get a user from the database, when given the id, or primary
   * key, of the user.
   *
   * @param id the primary key, unique id of the user.
   * @return The user of the assigned id number.
   */
  @Override
  public User getById(Integer id) {
    return this.getUser(id);
  }

  /**
   * Provides the business logic to delete a user from the database, when given the id, or primary
   * key of the user.
   *
   * @param id the primary key, unique id of the user.
   */
  @Override
  public void deleteUser(Integer id) {
    this.userRepository.deleteById(id);

  }
}
