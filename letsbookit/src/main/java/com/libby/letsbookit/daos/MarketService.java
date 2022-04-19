package com.libby.letsbookit.daos;

import com.libby.letsbookit.model.Frequencies;
import com.libby.letsbookit.model.Market;
import com.libby.letsbookit.repositories.MarketRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketService {

  @Autowired
  private MarketRepository marketRepository;

  public Integer createMarket(String name, String description, Frequencies frequency,
                              Integer contactNumber, String contactEmail, String website,
                              String socialMedia) {
    Market market = new Market(name, description, frequency, contactNumber, contactEmail, website,
                               socialMedia);
    this.marketRepository.save(market);
    return market.getId();
  }

  public Integer updateMarket(Integer id, String name, String description, Frequencies frequency,
      Integer contactNumber, String contactEmail, String website,
      String socialMedia) {
    Market market = (Market) this.findMarketById(id);
    market.setName(name);
    market.setDescription(description);
    market.setFrequency(frequency);
    market.setContactNumber(contactNumber);
    market.setContactEmail(contactEmail);
    market.setWebsite(website);
    market.setSocialMedia(socialMedia);
    this.marketRepository.save(market);
    return market.getId();
  }

  public Market findMarketById(Integer id) {
    Optional<Market> market = this.marketRepository.findById(id);
    return market.get();
  }

  public void deleteMarket(Integer id) {
    this.marketRepository.deleteById(id);
  }

  public List<Market> findAllMarkets() {
    return (List<Market>) this.marketRepository.findAll();
  }

}
