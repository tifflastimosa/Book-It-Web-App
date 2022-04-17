package com.libby.letsbookit.daos;

import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

//  @Autowired
//  private UserRepository userRepository;
//
//  @Override
//  public User createUser(User user) {
//    return this.userRepository.save(user);
//  }
//
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
