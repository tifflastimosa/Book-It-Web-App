package com.libby.letsbookit.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  private Integer eventId;
  private Integer vendorId;

  @Column(name = "table_name")
  private String tableName;
  @Column(name = "table_notes")
  private String tableNotes;
  @Column(name = "booked")
  private Boolean booked;
  @Column(name = "price")
  private Float price;

  public Stand(Integer id, Integer eventId, Integer vendorId, String tableName, String tableNotes,
      Boolean booked, Float price) {
    this.id = id;
    this.eventId = eventId;
    this.vendorId = vendorId;
    this.tableName = tableName;
    this.tableNotes = tableNotes;
    this.booked = booked;
    this.price = price;
  }

  // Can this be removed or does it serve a purpose?
  public Stand() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getEventId() {
    return eventId;
  }

  public void setEventId(Integer eventId) {
    this.eventId = eventId;
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


  public Integer getVendorId() {
    return vendorId;
  }

  public void setVendorId(Integer vendorId) {
    this.vendorId = vendorId;
  }
}
