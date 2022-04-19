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


/**
 * MarketController class provides CRUD requests for the client to interact with the database.
 */
// DO I NEED @CROSSORIGIN?
@RestController
@RequestMapping("/markets")
public class MarketController {

  // connect with the service layer
  @Autowired
  private MarketService marketService;

  // POST Request

  /**
   * Allows the client to request to create a Market, which represents a market organization, that
   * will be added to the database.
   *
   * @param name the name of the market.
   * @param description the description of the market.
   * @param frequency the frequency that the market is held.
   * @param contactNumber the contact phone number for the market.
   * @param contactEmail the contact email for the market.
   * @param website the website URL for the market.
   * @param socialMedia the social media link for the market.
   * @return Returns HTTP status, if the request is good or bad, and also returns the id.
   */
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
