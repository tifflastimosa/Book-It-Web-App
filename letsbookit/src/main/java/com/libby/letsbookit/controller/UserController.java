package com.libby.letsbookit.controller;

import com.libby.letsbookit.service.userservice.IUserService;
import com.libby.letsbookit.service.userservice.MarketStaffService;
import com.libby.letsbookit.model.User.Roles;
import com.libby.letsbookit.model.User.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController class provides CRUD requests for the client to interact with the database.
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {

  // connect with the service layer
  @Autowired
  private IUserService userService;
  
  @Autowired
  private MarketStaffService marketStaffService;
  // POST Request

  /**
   * Allows the client to request to create a User, which represents a user's account, that will
   * be added to the database.
   *
   * @param username the username of the user creating a new user account.
   * @param password the password of the user.
   * @param firstName the first name of the user.
   * @param lastName the last name of the user.
   * @param email the email of the user.
   * @param dateOfBirth the date of birth of the user.
   * @param role the role of the user.
   * @return Returns HTTP status, if the request is good or bad, and also returns the id.
   */
  @PostMapping(value = "/associate/{marketId}")
  public ResponseEntity<Integer> associateMarket(
                                            @PathVariable(value = "marketId", required = false) Integer marketId,
                                            @RequestParam(value = "username") String username,
                                            @RequestParam(value = "password") String password,
                                            @RequestParam(value = "firstName") String firstName,
                                            @RequestParam(value = "lastName") String lastName,
                                            @RequestParam(value = "email") String email,
                                            @RequestParam(value = "dateOfBirth") String dateOfBirth,
                                            @RequestParam(value = "role") Roles role) {
    try {
      return new ResponseEntity<>(this.userService.associateUser(username,
                                                              password,
                                                              firstName,
                                                              lastName,
                                                              email,
                                                              dateOfBirth,
                                                              role,
                                                              marketId), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping(value = "/create")
  public ResponseEntity<Integer> createUserNoMarket(
                                                    @RequestParam(value = "username") String username,
                                                    @RequestParam(value = "password") String password,
                                                    @RequestParam(value = "firstName") String firstName,
                                                    @RequestParam(value = "lastName") String lastName,
                                                    @RequestParam(value = "email") String email,
                                                    @RequestParam(value = "dateOfBirth") String dateOfBirth,
                                                    @RequestParam(value = "role") Roles role) {
    try {
      return new ResponseEntity<>(this.marketStaffService.createUserNoMarket(username,
                                                              password,
                                                              firstName,
                                                              lastName,
                                                              email,
                                                              dateOfBirth,
                                                              role), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  // GET Requests

  /**
   * Gets all users from the database.
   *
   * @return Returns HTTP status, if the request is good or bad, and also returns a list of all
   * users in the database.
   */
  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = this.userService.getAll();
    if (!users.isEmpty()) {
      return new ResponseEntity<>(users, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  /**
   * Gets a user from the database when given an id.
   *
   * @param id the autogenerated id of the user.
   * @return Returns HTTP status, if the request is good or bad, and also returns a list of all
   * users in the database.
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<User> getUser(@PathVariable Integer id) {
    User user = this.userService.getById(id);
    if (user != null) {
      return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  // PUT Request

  /**
   * Updates a user from the database when given an id.
   *
   * @param id the primary key, unique id of the user.
   * @param username the username of the user creating a new user account.
   * @param password the password of the user.
   * @param firstName the first name of the user.
   * @param lastName the last name of the user.
   * @param email the email of the user.
   * @param dateOfBirth the date of birth of the user.
   * @param role the role of the user.
   * @return Returns HTTP status, if the request is good or bad, and also returns the id of the user
   * if a successful request.
   */
  @PutMapping(value = "/update/{id}")
  public ResponseEntity<Integer> updateUser(@PathVariable("id") Integer id,
                                            @RequestParam(value = "username") String username,
                                            @RequestParam(value = "password") String password,
                                            @RequestParam(value = "firstName") String firstName,
                                            @RequestParam(value = "lastName") String lastName,
                                            @RequestParam(value = "email") String email,
                                            @RequestParam(value = "dateOfBirth") String dateOfBirth,
                                            @RequestParam(value = "role") Roles role) {

    try {
      return new ResponseEntity<>(this.userService.updateUser(id, username, password, firstName,
          lastName, email, dateOfBirth, role), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  // DELETE Request

  /**
   * Deletes a user from the database when given an id.
   *
   * @param id the primary key, unique id of the user.
   * @return Returns HTTP status, if the request is good or bad.
   */
  @DeleteMapping(value = "/delete/{id}")
  public ResponseEntity<HttpStatus> deletePlace(@PathVariable("id") Integer id) {
    try {
      this.userService.deleteUser(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
