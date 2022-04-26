package com.libby.letsbookit.service;

import com.libby.letsbookit.model.Vendor;
import com.libby.letsbookit.repositories.VendorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * VendorService Class provides the business logic for the client to interact with the database.
 */
@Service
public class VendorService {

  // connects to the repository
  @Autowired
  private VendorRepository vendorRepository;

  /**
   * Provides the business logic to create a market object and then add it as a record to the
   * database
   *
   * @param name the name of the vendor.
   * @param description the description of the vendor.
   * @param contactNumber the contact phone number for the vendor.
   * @param contactEmail the contact email for the vendor.
   * @param website the website URL for the vendor.
   * @param socialMedia the social media link for the vendor.
   * @return
   */
  public Integer createVendor(String name, String description, Integer contactNumber, String contactEmail,
      String website, String socialMedia) {
    Vendor vendor = new Vendor(name, description, contactNumber, contactEmail, website, socialMedia);
    this.vendorRepository.save(vendor);
    return vendor.getId();
  }

  /**
   * Provides the business logic to update a vendor object in the database.
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
  public Integer updateVendor(Integer id, String name, String description, Integer contactNumber, String contactEmail,
      String website, String socialMedia) {
    Vendor vendor = this.findVendorById(id);
    vendor.setName(name);
    vendor.setDescription(description);
    vendor.setContactNumber(contactNumber);
    vendor.setContactEmail(contactEmail);
    vendor.setWebsite(website);
    vendor.setSocialMedia(socialMedia);
    this.vendorRepository.save(vendor);
    return vendor.getId();
  }

  /**
   * Provides the business logic to get a vendor from the database, when given the id, or primary
   * key, of the vendor.
   *
   * @param id the primary key, unique id of the vendor.
   * @return The vendor of the assigned id number.
   */
  public Vendor findVendorById(Integer id) {
    Optional<Vendor> vendor = this.vendorRepository.findById(id);
    return vendor.get();
  }

  /**
   * Provides the business logic to delete a vendor from the database, when given the id,
   * or primary key of the vendor.
   *
   * @param id the primary key, unique id of the vendor.
   */
  public void deleteVendor(Integer id) {this.vendorRepository.deleteById(id);}

  /**
   * Provides the business logic to get all vendors from the database.
   *
   * @return A list of all vendors in the database.
   */
  public List<Vendor> findAllVendors() {return(List<Vendor>) this.vendorRepository.findAll();}
}
