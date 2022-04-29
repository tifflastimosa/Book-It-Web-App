package com.libby.letsbookit.service.userservice;

import com.libby.letsbookit.model.Market;
import com.libby.letsbookit.model.User.MarketStaff;
import com.libby.letsbookit.repositories.MarketRepository;
import com.libby.letsbookit.repositories.userrepository.UserBaseRepository;
import com.libby.letsbookit.service.MarketService;
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

  @Autowired
  private MarketService marketService;

  // POST methods

  /**
   * Saves a new user created by the client.
   *
   * @param user The user to be added to the database.
   * @return On successful addition, add user to the database.
   */
  public MarketStaff saveUser(MarketStaff user) {
    // TODO: Validate the age of a user by using dates
    return (MarketStaff) this.marketStaffRepository.save(user);
  }

  // PUT methods

  /**
   * User adds relation to Market object.
   *
   * @param id The id of the MarketStaff to be updated
   * @param marketId The id of the Market object.
   * @return The Market associated with the user.
   */
  public Market userToMarket(Integer id, Integer marketId) {
    MarketStaff marketStaff = (MarketStaff) super.getUser(id);
    Market market = this.marketService.findMarketById(marketId);
    marketStaff.setMarket(market);
    this.marketStaffRepository.save(marketStaff);
    return market;
  }

  /**
   * Update user information, the fields in the MarketStaff data model.
   *
   * @param id The id of the MarketStaff to retrieve record from the database to update.
   * @param user The new user information to update in the database.
   * @return Returns the MarketStaff with updated information.
   */
  public MarketStaff updateUser(Integer id, MarketStaff user) {
    // TODO: create a function in super class to avoid duplicate code
    MarketStaff fromDB = (MarketStaff) this.getById(id);
    fromDB.setUsername(user.getUsername());
    fromDB.setPassword(user.getPassword());
    fromDB.setFirstName(user.getFirstName());
    fromDB.setLastName(user.getLastName());
    fromDB.setEmail(user.getEmail());
    fromDB.setDateOfBirth(user.getDateOfBirth());
    fromDB.setRole(user.getRole());
    this.marketStaffRepository.save(fromDB);
    return fromDB;
  }

}
