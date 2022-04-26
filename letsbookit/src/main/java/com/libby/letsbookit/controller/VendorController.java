package com.libby.letsbookit.controller;

import com.libby.letsbookit.service.EventService;
import com.libby.letsbookit.service.StandService;
import com.libby.letsbookit.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * VendorController class provides CRUD requests for the client to interact with the database.
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/vendors")
public class VendorController {

  // connect with the service layer
  @Autowired
  private VendorService vendorService;

  // POST Request

  // TODO: add createStand()

  // GET Requests

  // TODO: add findAllStands()

  // TODO: add findStandById()

  // PUT Request

  // TODO: add updateStand()

  // DELETE Request

  // TODO: add deleteMarket()
}
