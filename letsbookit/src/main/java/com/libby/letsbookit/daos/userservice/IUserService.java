package com.libby.letsbookit.daos.userservice;

import com.libby.letsbookit.model.User.Roles;
import com.libby.letsbookit.model.User.User;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public interface IUserService {

  Integer createUser(String username, String password, String firstName, String lastName,
      String email, String dateOfBirth, Roles role);

  List<User> getAll();

  User getById(Integer id);

  Integer updateUser(Integer id, String username, String password, String firstName, String lastName,
      String email, String dateOfBirth, Roles role);

  void deleteUser(Integer id);

}
