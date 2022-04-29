package com.libby.letsbookit.service.userservice;

import com.libby.letsbookit.model.User.VendorStaff;
import com.libby.letsbookit.repositories.userrepository.UserBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Subtype class that inherits from abstract class UserService.
 */
@Service
public class VendorStaffService extends UserService {

  // connects to the repository
  @Autowired
  private UserBaseRepository vendorStaffRepository;

  /**
   * Saves a new VendorStaff created by the client.
   *
   * @param user The user to be added to the database.
   * @return On successful addition, the user added to the database and the user with
   * the autogenerated id.
   */
  // POST methods
  public VendorStaff saveVendorStaff(VendorStaff user) {
    return (VendorStaff) this.vendorStaffRepository.save(user);
  }

  // PUT methods

  /**
   * User adds relation to Vendor object.
   *
   * @param id The id of the VendorStaff to be updated.
   * @param vendorId The id of the Vendor object.
   * @return The Vendor associated with the user.
   */
  public Object userToVendor(Integer id, Integer vendorId) {
    // TODO: put logic here
    return null;
  }

  /**
   * Update user information, the fields in the VendorStaff data model.
   *
   * @param id The id of the VendorStaff to retrieve record from the database to update.
   * @param user The new user information to update in the database.
   * @return Returns the VendorStaff with updated information.
   */
  public VendorStaff updateUser(Integer id, VendorStaff user) {
    VendorStaff fromDB = (VendorStaff) this.getById(id);
    fromDB.setUsername(user.getUsername());
    fromDB.setPassword(user.getPassword());
    fromDB.setFirstName(user.getFirstName());
    fromDB.setLastName(user.getLastName());
    fromDB.setEmail(user.getEmail());
    fromDB.setDateOfBirth(user.getDateOfBirth());
    fromDB.setRole(user.getRole());
    this.vendorStaffRepository.save(fromDB);
    return fromDB;
  }

}
