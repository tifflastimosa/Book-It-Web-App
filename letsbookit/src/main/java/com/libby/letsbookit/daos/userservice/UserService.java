package com.libby.letsbookit.daos.userservice;

import com.libby.letsbookit.daos.userservice.IUserService;
import com.libby.letsbookit.model.User.User;
import com.libby.letsbookit.repositories.userrepository.UserBaseRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService<T extends User> implements IUserService {

  @Qualifier("userRepository")
  @Autowired
  private UserBaseRepository userRepo;

  @Override
  public <T> void createUser(T user) {
    this.userRepo.save(user);
  }

//  @Override
//  public User updateUser(User user, Integer id) {
//    User updatedUser;
//    Optional<User> savedUser = this.userRepository.findById(id);
//    updatedUser = savedUser.get();
//    updatedUser = this.userRepository.save(updatedUser);
//
//    return updatedUser;
//  }
//
//  @Override
//  public void deleteUser(int id) {
//    Optional<User> savedUser = this.userRepository.findById(id);
//    if (savedUser.isPresent()) {
//      User deleted = savedUser.get();
//      this.userRepository.delete(deleted);
//    }
//  }
//
//  @Override
//  public List<? extends User> findAllUsers() {
//    return (List<? extends User>) this.userRepository.findAll();
//  }
//
//  @Override
//  public User findUserById(int id) {
//    User user = new User();
//    Optional<User> savedUser = this.userRepository.findById(id);
//    if(savedUser.isPresent()) {
//      return savedUser.get();
//    }
//    return user;
//  }

}
