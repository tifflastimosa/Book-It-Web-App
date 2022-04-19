package com.libby.letsbookit.daos;

import com.libby.letsbookit.model.Stand;
import com.libby.letsbookit.repositories.StandRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandService {

  @Autowired
  private StandRepository standRepository;


  public Integer createStand(Integer eventId, Integer vendorId, String tableName,
      String tableNotes, Boolean booked, Float price) {
    Stand stand = new Stand(eventId, tableName, tableNotes, booked, price);
    this.standRepository.save(stand);
    return stand.getId();
  }

//
//  @Override
//  public Integer updateStand(Integer id, Integer eventId, Integer vendorId, String tableName,
//      String tableNotes, Boolean booked, Float price) {
//    Stand stand = this.findStandById(id);
//    stand.set
//
//  }
//
//  @Override
//  public void deleteStand(Integer id) {
//
//  }
//
//  @Override
//  public List findAllStands() {
//
//  }
//
//  @Override
//  public Stand findStandById(Integer id) {
//
//  }
}