package com.libby.letsbookit.daos;

import com.libby.letsbookit.model.User;
import com.libby.letsbookit.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService implements IUserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User createUser(User user) {
    return this.userRepository.save(user);
  }

  @Override
  public User updateUser(User user, Integer id) {
    User updatedUser = new User();
    Optional<User> savedUser = this.userRepository.findById(id);
    updatedUser = savedUser.get();
    updatedUser = this.userRepository.save(updatedUser);

    return updatedUser;
  }

  @Override
  public void deleteUser(int id) {
    // TODO: implement delete
  }

  @Override
  public List<? extends User> findAllUsers() {
    return (List<? extends User>) this.userRepository.findAll();
  }

  @Override
  public User findUserById(int id) {
    User user = new User();
    Optional<User> savedUser = this.userRepository.findById(id);
    if(savedUser.isPresent()) {
      return savedUser.get();
    }
    return user;
  }

}
