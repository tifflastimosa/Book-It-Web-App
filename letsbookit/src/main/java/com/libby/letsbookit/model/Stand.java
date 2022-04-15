//package com.libby.letsbookit.model;
//
//import java.time.LocalDateTime;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="stands")
//public class Stand {
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Integer id;
//  // TODO: How to implement fks?
//  private Integer eventId;
//  private Integer vendorId;
//  private String tableName;
//  private String tableNotes;
//  private Boolean booked;
//  private Double price;
//  // TODO: How to capture dates for MySQL?
//  private LocalDateTime lastUpdated;
//
//  public Integer getId() {
//    return id;
//  }
//
//  public void setId(Integer id) {
//    this.id = id;
//  }
//
//  public Integer getEventId() {
//    return eventId;
//  }
//
//  public void setEventId(Integer eventId) {
//    this.eventId = eventId;
//  }
//
//  public Integer getVendorId() {
//    return vendorId;
//  }
//
//  public void setVendorId(Integer vendorId) {
//    this.vendorId = vendorId;
//  }
//
//  public String getTableName() {
//    return tableName;
//  }
//
//  public void setTableName(String tableName) {
//    this.tableName = tableName;
//  }
//
//  public String getTableNotes() {
//    return tableNotes;
//  }
//
//  public void setTableNotes(String tableNotes) {
//    this.tableNotes = tableNotes;
//  }
//
//  public Boolean getBooked() {
//    return booked;
//  }
//
//  public void setBooked(Boolean booked) {
//    this.booked = booked;
//  }
//
//  public Double getPrice() {
//    return price;
//  }
//
//  public void setPrice(Double price) {
//    this.price = price;
//  }
//
//  public LocalDateTime getLastUpdated() {
//    return lastUpdated;
//  }
//
//  public void setLastUpdated(LocalDateTime lastUpdated) {
//    this.lastUpdated = lastUpdated;
//  }
//
//}
