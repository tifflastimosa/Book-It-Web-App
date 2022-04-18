package com.libby.letsbookit.model.User;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity(name = "market_staff")
@PrimaryKeyJoinColumn(name = "id")
public class MarketStaff extends User{  // maps the properties from parent class

  @Enumerated(EnumType.STRING)
  private Roles role;

  /**
   * Constructor for MarketStaff.
   *
   * @param username the username of the user creating a new user account.
   * @param password the password of the user.
   * @param firstName the first name of the user.
   * @param lastName the last name of the user.
   * @param email the email of the user.
   * @param dateOfBirth the date of birth of the user.
   * @param role the role of the user.
   */
  public MarketStaff(String username, String password, String firstName, String lastName,
      String email, LocalDateTime dateOfBirth, Roles role) {
    super(username, password, firstName, lastName, email, dateOfBirth);
    this.role = role;
  }

  /**
   * Constructor with no parameters for MarketStaff.
   */
  public MarketStaff() {

  }

  /**
   * Gets for the role of the user.
   *
   * @return The role of the user.
   */
  public Roles getRole() {
    return this.role;
  }

  /**
   * Setter for the role of the user.
   *
   * @param role The role of the user.
   */
  public void setRole(Roles role) {
    this.role = role;
  }

}
