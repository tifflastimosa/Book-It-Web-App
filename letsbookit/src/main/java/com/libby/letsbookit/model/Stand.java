package com.libby.letsbookit.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * A class that represents a stand that is at a scheduled event that can be booked by a vendor
 */

@Entity
@Table(name="stands")
public class Stand {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name="event_Id")
  private Event event;

  @ManyToOne
  @JoinColumn(name="vendor_Id")
  private Vendor vendor;

  @Column(name = "table_name")
  private String tableName;
  @Column(name = "table_notes")
  private String tableNotes;
  @Column(name = "booked")
  private Boolean booked;
  @Column(name = "price")
  private Float price;

  /**
   * Constructor for stand.
   *
   * @param event the stand belongs to.
   * @param vendor that has booked the stand.
   * @param tableName that helps identify the stand.
   * @param tableNotes that describe the stand.
   * @param booked status of the stand.
   * @param price it costs to rent the stand.
   */
  public Stand(Event event, Vendor vendor, String tableName, String tableNotes,
      Boolean booked, Float price) {
    this.event = event;
    this.vendor = vendor;
    this.tableName = tableName;
    this.tableNotes = tableNotes;
    this.booked = booked;
    this.price = price;
  }

  /**
   * Constructor with no parameters for Stand.
   */
  public Stand() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public String getTableNotes() {
    return tableNotes;
  }

  public void setTableNotes(String tableNotes) {
    this.tableNotes = tableNotes;
  }

  public Boolean getBooked() {
    return booked;
  }

  public void setBooked(Boolean booked) {
    this.booked = booked;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Vendor getVendor() {
    return vendor;
  }

  public void setVendor(Vendor vendor) {
    this.vendor = vendor;
  }
}
