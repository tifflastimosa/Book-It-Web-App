package com.libby.letsbookit.daos.userservice;

import com.libby.letsbookit.model.User.Roles;
import com.libby.letsbookit.model.User.User;
import com.libby.letsbookit.repositories.userrepository.UserBaseRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class UserService<T extends User> implements IUserService {

  @Autowired
  private UserBaseRepository userRepository;

  public LocalDateTime helperLocalDateTime(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return LocalDateTime.parse(date,formatter);
  }

  @Override
  public List<User> getAll() {
    return (List<User>) this.userRepository.findAll();
  }

  private User getUser(Integer id) {
    Optional<User> userOptional = this.userRepository.findById(id);
    return userOptional.get();
  }

  @Override
  public User getById(Integer id) {
    return this.getUser(id);
  }

//  @Override
//  public void deleteUser(int id) {
//    Optional<User> savedUser = this.userRepository.findById(id);
//    if (savedUser.isPresent()) {
//      User deleted = savedUser.get();
//      this.userRepository.delete(deleted);
//    }
//  }
//


  @Override
  public void deleteUser(Integer id) {
    this.userRepository.deleteById(id);

  }
}
