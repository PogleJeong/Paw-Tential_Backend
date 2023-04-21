package mul.cam.a.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.market.dao.MarketDao;
import mul.cam.a.market.dto.MarketDto;

@Service
@Transactional
public class MarketService {
	@Autowired
	MarketDao dao;
	/*
	public MarketDto marketSearch(String id) {
		//return dao.marketSearch(id);
	}
	
	public MarketDto printAllMarketSearch() {
		return dao.
	}
	*/
}
