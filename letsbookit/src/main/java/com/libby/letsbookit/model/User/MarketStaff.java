package com.libby.letsbookit.model.User;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "market_staff")
@PrimaryKeyJoinColumn(name = "id")
public class MarketStaff extends User{  // maps the properties from parent class

  @Enumerated(EnumType.STRING)
  private Roles role;

  public MarketStaff(String username, String password, String firstName, String lastName,
      String email, LocalDateTime dateOfBirth, Roles role) {
    super(username, password, firstName, lastName, email, dateOfBirth);
    this.role = role;
  }
}
