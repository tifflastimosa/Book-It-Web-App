package com.libby.letsbookit.model.User;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "market_staff")
@PrimaryKeyJoinColumn(name = "id")
public class MarketStaff extends User{  // maps the properties from parent class

  // the pk of the MarketStaff

  @Enumerated(EnumType.STRING)
  private Roles role;

  public MarketStaff(Integer id, String username, String password, String firstName,
      String lastName, String email, LocalDateTime dateOfBirth,
      Roles role) {
    super(id, username, password, firstName, lastName, email, dateOfBirth);
    this.role = role;
  }

  public MarketStaff() {

  }
}
