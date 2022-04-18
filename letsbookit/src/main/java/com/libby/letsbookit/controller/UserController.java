package com.libby.letsbookit.controller;


import com.libby.letsbookit.daos.userservice.MarketStaffService;
import com.libby.letsbookit.model.User.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private MarketStaffService marketStaffService;

  @PostMapping(value = "/create")
  public ResponseEntity<Integer> createUser(@RequestParam(value = "username") String username,
                                           @RequestParam(value = "password") String password,
                                           @RequestParam(value = "firstName") String firstName,
                                           @RequestParam(value = "lastName") String lastName,
                                           @RequestParam(value = "email") String email,
                                           @RequestParam(value = "dateOfBirth") String dateOfBirth,
                                           @RequestParam(value = "role") Roles role) {
    try {
      return new ResponseEntity<>(this.marketStaffService.createUser(username, password, firstName, lastName, email, dateOfBirth, role), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
