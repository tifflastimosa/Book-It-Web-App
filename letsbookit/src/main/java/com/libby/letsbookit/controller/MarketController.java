package com.libby.letsbookit.controller;


import com.libby.letsbookit.daos.MarketService;
import com.libby.letsbookit.model.Frequencies;
import com.libby.letsbookit.model.Market;
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

  // QUESTION: Naming convention to keep consistent.

  // GET Requests

  /**
   * Gets all markets from the database.
   *
   * @return Returns HTTP status, if the request is good or bad, and also returns a list of all
   * markets in the database.
   */
  @GetMapping(value = "/all")
  public ResponseEntity<List<Market>> findAllMarkets() {
    List<Market> markets = this.marketService.findAllMarkets();
    if (!markets.isEmpty()) {
      return new ResponseEntity<>(markets, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }


  // TODO: review and edit getUser documentation on UserController
  /**
   * Gets a market from the database when given an id.
   *
   * @param id the autogenerated id of the market
   * @return Returns HTTP status, if the request is good or bad, and also returns the market if a
   * successful request.
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<Market> findMarketById(@PathVariable Integer id) {
    Market market = this.marketService.findMarketById(id);
    if (market != null) {
      return new ResponseEntity<>(market, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  // PUT Request

  /**
   * Updates a market from the database when given an id.
   *
   * @param id the primary key, unique id of the market.
   * @param name the name of the market.
   * @param description the description of the market.
   * @param frequency the frequency that the market is held.
   * @param contactNumber the contact phone number for the market.
   * @param contactEmail the contact email for the market.
   * @param website the website URL for the market.
   * @param socialMedia the social media link for the market.
   * @return Returns HTTP status, if the request is good or bad, and also returns the id of the
   * market if a successful request.
   */
  @PutMapping(value = "/update/{id}")
  public ResponseEntity<Integer> updateMarket(@PathVariable("id") Integer id,
                                              @RequestParam(value = "name") String name,
                                              @RequestParam(value = "description") String description,
                                              @RequestParam(value = "frequency") Frequencies frequency,
                                              @RequestParam(value = "contactNumber") Integer contactNumber,
                                              @RequestParam(value = "contactEmail") String contactEmail,
                                              @RequestParam(value = "website") String website,
                                              @RequestParam(value = "socialMedia") String socialMedia) {
    try {
      return new ResponseEntity<>(this.marketService.updateMarket(id, name, description,
          frequency, contactNumber, contactEmail, website, socialMedia), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  // DELETE Request

  // QUESTION: UserController has deletePlace instead of deleteUser, Is this intentional?

  /**
   * Deletes a market from the database when given an id.
   *
   * @param id the primary key, unique id of the market.
   * @return Returns the HTTP status, if the request is good or bad.
   */
  @DeleteMapping(value = "/delete/{id}")
  public ResponseEntity<HttpStatus> deleteMarket(@PathVariable("id") Integer id) {
    try {
      this.marketService.deleteMarket(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
