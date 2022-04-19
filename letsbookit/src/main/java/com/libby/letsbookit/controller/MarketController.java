package com.libby.letsbookit.controller;


import com.libby.letsbookit.daos.MarketService;
import com.libby.letsbookit.model.Frequencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/markets")
public class MarketController {

  @Autowired
  private MarketService marketService;


  @PostMapping(value = "/create")
  public ResponseEntity<Integer> createMarket(@RequestParam(value = "name") String name,
                                              @RequestParam(value = "description") String description,
                                              @RequestParam(value = "frequency") Frequencies frequency,
                                              @RequestParam(value = "contactNumber") Integer contactNumber,
                                              @RequestParam(value = "contactEmail") String contactEmail,
                                              @RequestParam(value = "website") String website,
                                              @RequestParam(value = "socialMedia") String socialMedia) {
    try {
      return new ResponseEntity<>(
          this.marketService.createMarket(name, description, frequency, contactNumber,
                                          contactEmail, website, socialMedia), HttpStatus.OK);

    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  //TODO: need to create GET, PUT, and DELETE requests
}
