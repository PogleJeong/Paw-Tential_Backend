package mul.cam.a.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.market.dto.MarketDto;
import mul.cam.a.market.service.MarketService;

@RestController
public class MarketController {
	/*
	@Autowired
	MarketService service;
	
	@PostMapping(value="/marketSearch")
	public MarketDto marketSearch(String tab, String selectedOption, String searchWord) {
		// tab : 전체/판매/나눔
		// selectedOption : 전체/제목/내용 
		
		return service.marketSearch(id);
	}*/
}
