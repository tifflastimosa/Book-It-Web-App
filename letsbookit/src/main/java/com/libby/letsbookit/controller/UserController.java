package com.libby.letsbookit.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


//  @Qualifier("userService")
//  @Autowired
//  private UserService serviceLayer;
//
//  @PostMapping(value = "/create")
//  public ResponseEntity createUser(@RequestParam(value = "username") String username,
//                                           @RequestParam(value = "password") String password,
//                                           @RequestParam(value = "first_name", required = false) String firstName
//                                            ) {
////
////    try {
////
////    } catch (Exception e) {
////      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
////    }
////    return new ResponseEntity<>()this.serviceLayer.createUser(username, password, firstName, null, null, null);
//  }

}
