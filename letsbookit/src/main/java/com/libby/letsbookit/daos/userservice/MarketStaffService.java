package com.libby.letsbookit.daos.userservice;

import com.libby.letsbookit.model.Market;
import com.libby.letsbookit.model.User.MarketStaff;
import com.libby.letsbookit.model.User.Roles;
import com.libby.letsbookit.model.User.User;
import com.libby.letsbookit.repositories.MarketRepository;
import com.libby.letsbookit.repositories.userrepository.UserBaseRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Subtype class that inherits from abstract class UserService.
 */
@Service
public class MarketStaffService extends UserService {

  // connects to the repository
  @Autowired
  private UserBaseRepository marketStaffRepository;

  @Autowired
  private MarketRepository marketRepository;

  /**
   * Provides the business logic to create a user object and then add it as a record to the
   * database.
   *
   * @param username the username of the user creating a new user account.
   * @param password the password of the user.
   * @param firstName the first name of the user.
   * @param lastName the last name of the user.
   * @param email the email of the user.
   * @param dateOfBirth the date of birth of the user.
   * @param role the role of the user.
   * @return The autogenerated id of the user.
   */
  @Override
  public Integer associateUser(String username, String password, String firstName, String lastName,
      String email, String dateOfBirth, Roles role, Integer marketId) throws Exception {

    LocalDateTime objectDateOfBirth = super.helperLocalDateTime(dateOfBirth);

    MarketStaff marketStaff = new MarketStaff(username, password, firstName, lastName, email, objectDateOfBirth, role);

    MarketStaff marketStaffRep =
        (MarketStaff) this.marketRepository
            .findById(marketId)
            .map(market -> {marketStaff.setMarket(market);
              return this.marketStaffRepository.save(marketStaff);})
            .orElseThrow(() -> new Exception("Not found"));

    return marketStaff.getId();
  }

  public Integer createUserNoMarket(String username, String password, String firstName, String lastName,
      String email, String dateOfBirth, Roles role) {
    LocalDateTime objectDateOfBirth = super.helperLocalDateTime(dateOfBirth);

    MarketStaff marketStaff = new MarketStaff(username, password, firstName, lastName, email, objectDateOfBirth, role);
    this.marketStaffRepository.save(marketStaff);
    return marketStaff.getId();
  }

  /**
   * Updates the user that is a market staff.
   * @param id the primary key, unique id of the user.
   * @param username the username of the user creating a new user account.
   * @param password the password of the user.
   * @param firstName the first name of the user.
   * @param lastName the last name of the user.
   * @param email the email of the user.
   * @param dateOfBirth the date of birth of the user.
   * @param role the role of the user.
   * @return The autogenerated id of the user.
   */
  @Override
  public Integer updateUser(Integer id, String username, String password, String firstName,
      String lastName, String email, String dateOfBirth, Roles role) {
    // TODO: create a function in super class to avoid duplicate code
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
