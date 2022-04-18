package com.libby.letsbookit.daos.userservice;

import com.libby.letsbookit.model.User.MarketStaff;
import com.libby.letsbookit.model.User.Roles;
import com.libby.letsbookit.model.User.User;
import com.libby.letsbookit.repositories.userrepository.UserBaseRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketStaffService extends UserService {

  @Autowired
  private UserBaseRepository marketStaffRepository;

  @Override
  public Integer createUser(String username, String password, String firstName, String lastName,
      String email, String dateOfBirth, Roles role) {
    LocalDateTime objectDateOfBirth = super.helperLocalDateTime(dateOfBirth);
    User marketStaff = new MarketStaff(username, password, firstName, lastName, email, objectDateOfBirth, role);
    marketStaffRepository.save(marketStaff);
    return marketStaff.getId();
  }

  @Override
  public Integer updateUser(Integer id, String username, String password, String firstName,
      String lastName, String email, String dateOfBirth, Roles role) {
    MarketStaff ms = (MarketStaff) this.getById(id);
    ms.setUsername(username);
    ms.setPassword(password);
    ms.setFirstName(firstName);
    ms.setLastName(lastName);
    ms.setEmail(email);
    ms.setDateOfBirth(helperLocalDateTime(dateOfBirth));
    ms.setRole(role);
    this.marketStaffRepository.save(ms);
    return ms.getId();
  }
}
