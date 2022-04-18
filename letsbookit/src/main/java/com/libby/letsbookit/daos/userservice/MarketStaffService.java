package com.libby.letsbookit.daos.userservice;

import com.libby.letsbookit.model.User.MarketStaff;
import com.libby.letsbookit.model.User.Roles;
import com.libby.letsbookit.model.User.User;
import com.libby.letsbookit.repositories.userrepository.MarketStaffRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketStaffService extends UserService {

  @Autowired
  private MarketStaffRepository marketStaffRepository;

  @Override
  public void createUser(String username, String password, String firstName, String lastName,
      String email, String dateOfBirth, Roles role) {
    super.createUser(username, password, firstName, lastName, email, dateOfBirth, role);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime objectDateOfBirth = LocalDateTime.parse(dateOfBirth,formatter);
    User marketStaff = new MarketStaff(username, password, firstName, lastName, email, objectDateOfBirth, role);

  }
}
