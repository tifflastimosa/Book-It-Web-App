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

  public Event() {

  }

  public Integer getId() { return id; }
  public void setId() { this.id = id;}

  public Integer getMarketId(){ return marketId; }
  public void setMarketId(){ this.marketId = marketId; }

  public String getName(){ return name; }
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
