package com.libby.letsbookit.controller;

import com.libby.letsbookit.model.Vendor;
import com.libby.letsbookit.service.VendorService;
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

  /**
   * Allows the client to request to create a Vendor that
   * will be added to the database.
   *
   * @param name the name of the vendor.
   * @param description the description of the vendor.
   * @param contactNumber the contact phone number for the vendor.
   * @param contactEmail the contact email for the vendor.
   * @param website the website URL for the vendor.
   * @param socialMedia the social media link for the vendor.
   * @return Returns HTTP status, if the request is good or bad, and also returns the id.
   */
  @PostMapping(value = "/create")
  public ResponseEntity<Integer> createVendor(@RequestParam(value = "name") String name,
      @RequestParam(value = "description") String description,
      @RequestParam(value = "contactNumber") Integer contactNumber,
      @RequestParam(value = "contactEmail") String contactEmail,
      @RequestParam(value = "website") String website,
      @RequestParam(value = "socialMedia") String socialMedia) {

    try {
      return new ResponseEntity<>(
          this.vendorService.createVendor(name, description, contactNumber, contactEmail, website,
              socialMedia), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  // GET Requests

  /**
   * Gets all vendors from the database.
   *
   * @return Returns HTTP status, if the request is good or bad, and also returns a list of all
   * vendors in the database.
   */
  @GetMapping
  public ResponseEntity<List<Vendor>> getAllVendors() {
    List<Vendor> vendors = this.vendorService.findAllVendors();
    if (!vendors.isEmpty()) {
      return new ResponseEntity<>(vendors, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  /**
   * Gets a vendor from the database when given an id.
   *
   * @param id the autogenerated id of the vendor
   * @return Returns HTTP status, if the request is good or bad, and also returns the vendor if a
   * successful request.
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<Vendor> getVendor(@PathVariable Integer id) {
    Vendor vendor = this.vendorService.findVendorById(id);
    if (vendor != null) {
      return new ResponseEntity<>(vendor, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  // PUT Request

  /**
   * Updates a vendor from the database when given an id.
   *
   * @param id the primary key, unique id of the vendor.
   * @param name the name of the vendor.
   * @param description the description of the vendor.
   * @param contactNumber the contact phone number for the vendor.
   * @param contactEmail the contact email for the vendor.
   * @param website the website URL for the vendor.
   * @param socialMedia the social media link for the vendor.
   * @return
   */
  @PutMapping(value = "/update/{id}")
  public ResponseEntity<Integer> updateVendor(@PathVariable("id") Integer id,
                                              @RequestParam(value = "name") String name,
                                              @RequestParam(value = "description") String description,
                                              @RequestParam(value = "contactNumber") Integer contactNumber,
                                              @RequestParam(value = "contactEmail") String contactEmail,
                                              @RequestParam(value = "website") String website,
                                              @RequestParam(value = "socialMedia") String socialMedia) {
    try {
      return new ResponseEntity<>(this.vendorService.updateVendor(id, name, description,
          contactNumber, contactEmail, website, socialMedia), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  // DELETE Request

  /**
   * Deletes a vendor from the database when given an id.
   *
   * @param id the primary key, unique id of the vendor.
   * @return Returns the HTTP status, if the request is good or bad.
   */
  @DeleteMapping(value = "/delete/{id}")
  public ResponseEntity<HttpStatus> deleteVendor(@PathVariable("id") Integer id) {
    try {
      this.vendorService.deleteVendor(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
