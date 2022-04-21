package com.libby.letsbookit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
A class that represents an event that is scheduled to occur at a market.
*/

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "event_name")
    private String name;

    @Column(name = "start")
    private LocalDateTime start;

    @Column(name = "end")
    private LocalDateTime end;

    @Column(name = "location")
    private String location;

    @Column(name = "venue_Layout")
    private String venueLayout;

    // TODO: implement market for next milestone
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "market_id")
    @JsonIgnore
    private Market market;


  /**
   * Constructor for Event.
   *
   * @param name the name of the event.
   * @param start the start time of the event.
   * @param end the end time of the event.
   * @param location the location of the event.
   * @param venueLayout the layout of the venue where the event will be held.
   * @return Returns HTTP status, if the request is good or bad, and also returns the id.
   */
    public Event(String name, LocalDateTime start, LocalDateTime end,
        String location, String venueLayout) {
      this.name = name;
      this.start = start;
      this.end = end;
      this.location = location;
      this.venueLayout = venueLayout;

    }


  public Event() {

  }

  /**
   * Gets the id of the event.
   *
   * @return the id of the event.
   */
  public Integer getId() { return id; }

  /**
   * Sets the id of the event.
   *
   * @param id The id of the event.
   */
  public void setId(Integer id) { this.id = id;}

  /**
   * Gets the marketId of the event.
   *
   * @return the marketId of the event.
   */
  public Market getMarket(){ return market; }

  //Not sure we want this since it's the FK for Market.
  /**
   * Sets the marketId of the event.
   *
   * @param market The id of the event.
   */
  public void setMarket(Market market){ this.market = market; }

  /**
   * Gets the name of the event.
   *
   * @return the name of the event.
   */
  public String getName(){ return name; }

  /**
   * Sets the id of the event.
   *
   * @param name The name of the event.
   */
  public void setName(String name) {this.name = name; }

  /**
   * Gets the start time of the event.
   *
   * @return the start time of the event.
   */
  public LocalDateTime getStart(){ return start; }

  /**
   * Sets the start time of the event.
   *
   * @param start The start time of the event.
   */
  public void setStart(LocalDateTime start) {this.start = start; }

  /**
   * Gets the end time of the event.
   *
   * @return the end time of the event.
   */
  public LocalDateTime getEnd() {return end; }

  /**
   * Sets the end time of the event.
   *
   * @param end The end time of the event.
   */
  public void setEnd(LocalDateTime end) {this.end = end; }

  /**
   * Gets the location of the event.
   *
   * @return the location of the event.
   */
  public String getLocation() {return location; }

  /**
   * Sets the location of the event.
   *
   * @param location The location of the event.
   */
  public void setLocation(String location) {this.location = location; }

  /**
   * Gets the venue layout of the event.
   *
   * @return the venue layout of the event.
   */
  public String getVenueLayout() {return venueLayout; }

  /**
   * Sets the venue layout of the event.
   *
   * @param venueLayout The venue layout of the event.
   */
  public void setVenueLayout(String venueLayout) {this.venueLayout = venueLayout; }



}
