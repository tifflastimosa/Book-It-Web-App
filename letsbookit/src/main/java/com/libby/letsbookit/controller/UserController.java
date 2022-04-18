package com.libby.letsbookit.controller;

import com.amazonaws.Response;
import com.libby.letsbookit.daos.userservice.IUserService;
import com.libby.letsbookit.model.User.Roles;
import com.libby.letsbookit.model.User.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private IUserService userService;

  @PostMapping(value = "/create")
  public ResponseEntity<Integer> createUser(@RequestParam(value = "username") String username,
                                           @RequestParam(value = "password") String password,
                                           @RequestParam(value = "firstName") String firstName,
                                           @RequestParam(value = "lastName") String lastName,
                                           @RequestParam(value = "email") String email,
                                           @RequestParam(value = "dateOfBirth") String dateOfBirth,
                                           @RequestParam(value = "role") Roles role) {
    try {
      return new ResponseEntity<>(this.userService.createUser(username, password, firstName, lastName, email, dateOfBirth, role), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping(value = "/all")
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = this.userService.getAll();
    if (!users.isEmpty()) {
      return new ResponseEntity<>(users, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<User> getUser(@PathVariable Integer id) {
    User user = this.userService.getById(id);
    if (user != null) {
      return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

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
