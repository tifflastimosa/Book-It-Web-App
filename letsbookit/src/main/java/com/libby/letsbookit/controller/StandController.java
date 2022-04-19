package com.libby.letsbookit.controller;

import com.libby.letsbookit.daos.StandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stands")
public class StandController {

  @Autowired
  private StandService standService;

  // POST Request

  // TODO: add createStand()

  // GET Requests

  // TODO: add findAllStands()

  // TODO: add findStandById()

  // PUT Request

  // TODO: add updateStand()

  // DELETE Request

  // TODO: add deleteMarket()
}
