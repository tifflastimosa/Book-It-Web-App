package com.libby.letsbookit.daos.userservice;

import com.libby.letsbookit.model.User.Roles;
import com.libby.letsbookit.model.User.User;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface IUserService {

  abstract Integer createUser(String username, String password, String firstName, String lastName,
      String email, String dateOfBirth, Roles role);

}
