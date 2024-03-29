package com.libby.letsbookit.model.User;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


/**
 * Super class that represents a user who will either be a market staff or a vendor, both of
 * which are subtype.
 */
@Entity(name = "joined_base_user")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

  // the unique id that is autogenerated
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "date_of_birth")
  private LocalDateTime dateOfBirth;

  /**
   * Constructor for user.
   *
   * @param username the username of the user creating a new user account.
   * @param password the password of the user.
   * @param firstName the first name of the user.
   * @param lastName the last name of the user.
   * @param email the email of the user.
   * @param dateOfBirth the date of birth of the user.
   */
  public User(String username, String password, String firstName,
      String lastName, String email, LocalDateTime dateOfBirth) {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
  }

  /**
   * Constructor with no parameters for User.
   */
  public User() {
  }

  /**
   * Gets the id of the user.
   *
   * @return The id of the user.
   */
  public Integer getId() {
    return this.id;
  }

  /**
   * Sets the id of the user.
   *
   * @param id The id of the user.
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Gets the first name of the user.
   *
   * @return The first name of the user.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Sets the first name of the user.
   *
   * @param firstName The first name of the user.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * The last name of the user.
   *
   * @return The last name of the user.
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Sets the last name of the user.
   *
   * @param lastName The last name of the user.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets the username of the user.
   *
   * @return The username of the user.
   */
  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Gets the password of the user.
   *
   * @return The password of the user.
   */
  public String getPassword() {
    return this.password;
  }

  /**
   * Sets the password of the user.
   *
   * @param password The password of the user.
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Gets the date of birth of the user.
   *
   * @return The date of birth of the user.
   */
  public LocalDateTime getDateOfBirth() {
    return this.dateOfBirth;
  }

  /**
   * Sets the date of birth of the user.
   *
   * @param dateOfBirth the date of birth of the user.
   */
  public void setDateOfBirth(LocalDateTime dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  /**
   * Gets the email of the user.
   *
   * @return The email of the user.
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Sets the email of the user.
   *
   * @param email The email of the user.
   */
  public void setEmail(String email) {
    this.email = email;
  }

}


