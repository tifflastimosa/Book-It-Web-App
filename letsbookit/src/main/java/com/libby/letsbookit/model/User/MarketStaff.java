package com.libby.letsbookit.model.User;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class MarketStaff extends User{

  @Enumerated(EnumType.ORDINAL)
  private Roles role;

}
