package com.libby.letsbookit.daos.userservice;

import com.libby.letsbookit.model.User.MarketStaff;
import com.libby.letsbookit.model.User.Roles;
import com.libby.letsbookit.model.User.User;
import com.libby.letsbookit.repositories.userrepository.MarketStaffRepository;
import com.libby.letsbookit.repositories.userrepository.UserBaseRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketStaffService extends UserService {

  @Autowired
  private UserBaseRepository marketStaffRepository;

  @Override
  public Integer createUser(String username, String password, String firstName, String lastName,
      String email, String dateOfBirth, Roles role) {
    super.createUser(username, password, firstName, lastName, email, dateOfBirth, role);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime objectDateOfBirth = LocalDateTime.parse(dateOfBirth,formatter);
    User marketStaff = new MarketStaff(username, password, firstName, lastName, email, objectDateOfBirth, role);
    marketStaffRepository.save(marketStaff);
    return marketStaff.getId();
  }

}
