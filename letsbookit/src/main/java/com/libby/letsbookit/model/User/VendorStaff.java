package com.libby.letsbookit.model.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.libby.letsbookit.model.Vendor;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "vendor_staff")
@PrimaryKeyJoinColumn(name = "id")
public class VendorStaff extends User {

  @Enumerated(EnumType.STRING)
  private Roles role;

  @ManyToOne(optional = true, fetch = FetchType.LAZY)
  @JoinColumn(name = "vendor_id")
  @JsonIgnore
  private Vendor vendor;

  /**
   * Constructor for Vendor.
   *
   * @param username the username of the user creating a new user account.
   * @param password the password of the user.
   * @param firstName the first name of the user.
   * @param lastName the last name of the user.
   * @param email the email of the user.
   * @param dateOfBirth the date of birth of the user.
   * @param role the role of the user.
   */
  public VendorStaff(String username, String password, String firstName, String lastName,
      String email, LocalDateTime dateOfBirth, Roles role) {
    super(username, password, firstName, lastName, email, dateOfBirth);
    this.role = role;
  }

  /**
   * Constructor with no parameters for Vendor.
   */
  public VendorStaff() {
  }

  public Roles getRole() {
    return role;
  }

  public void setRole(Roles role) {
    this.role = role;
  }
}
