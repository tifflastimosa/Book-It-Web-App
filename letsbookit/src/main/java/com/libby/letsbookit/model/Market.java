package com.libby.letsbookit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "markets")
public class Market {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "market_name")
  private String name;
  @Column(name = "description")
  private String description;
  @Column(name = "frequency")
  private Frequencies frequency;
  @Column(name = "contact_number")
  private Integer contactNumber;
  @Column(name = "contact_email")
  private String contactEmail;
  @Column(name = "website")
  private String website;
  @Column(name = "social_media")
  private String socialMedia;

  public Market(String name, String description, Frequencies frequency,
      Integer contactNumber, String contactEmail, String website, String socialMedia) {
    this.name = name;
    this.description = description;
    this.frequency = frequency;
    this.contactNumber = contactNumber;
    this.contactEmail = contactEmail;
    this.website = website;
    this.socialMedia = socialMedia;
  }

  public Market() {

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Frequencies getFrequency() {
    return frequency;
  }

  public void setFrequency(Frequencies frequency) {
    this.frequency = frequency;
  }

  public Integer getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(Integer contactNumber) {
    this.contactNumber = contactNumber;
  }

  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public String getSocialMedia() {
    return socialMedia;
  }

  public void setSocialMedia(String socialMedia) {
    this.socialMedia = socialMedia;
  }
}
