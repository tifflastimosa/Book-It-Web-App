package com.libby.letsbookit.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Integer marketId;

    @Column(name = "name")
    private String name;
    @Column(name = "start")
    private LocalDateTime start;
    @Column(name = "end")
    private LocalDateTime end;
    @Column(name = "location")
    private String location;
    @Column(name = "venue_Layout")
    private String venueLayout;

  /**
   * Constructor for Event.
   *
   * @param marketId the foreign key that represents the marketId.
   * @param name the name of the event.
   * @param start the start time of the event.
   * @param end the end time of the event.
   * @param location the location of the event.
   * @param venueLayout the layout of the venue where the event will be held.
   * @return Returns HTTP status, if the request is good or bad, and also returns the id.
   */
    public Event (Integer id, Integer marketId, String name, LocalDateTime start, LocalDateTime end,
        String location, String venueLayout) {
      this.id = id;
      this.marketId = marketId;
      this.name = name;
      this.start = start;
      this.end = end;
      this.location = location;
      this.venueLayout = venueLayout;

    }
  /**
   * Constructor with no parameters for Event.
   */
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
  public void setId() { this.id = id;}

  /**
   * Gets the marketId of the event.
   *
   * @return the marketId of the event.
   */
  public Integer getMarketId(){ return marketId; }

  //Not sure we want this since it's the FK for Market.
  /**
   * Sets the marketId of the event.
   *
   * @param marketId The id of the event.
   */
  public void setMarketId(){ this.marketId = marketId; }

  /**
   * Gets the name of the event.
   *
   * @return the name of the event.
   */
  public String getName(){ return name; }

  /**
   * Sets the id of the event.
   *
   * @param id The id of the event.
   */
  public void setName() {this.name = name; }

  public LocalDateTime getStart(){ return start; }
  public void setStart() {this.start = start; }

  public LocalDateTime getEnd() {return end; }
  public void setEnd() {this.end = end; }

  public String getLocation() {return location; }
  public void setLocation() {this.location = location; }

  public String getVenueLayout() {return venueLayout; }
  public void setVenueLayout() {this.venueLayout = venueLayout; }

}
