package mul.cam.a.pawtens.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.feed.dto.FeedDto;
import mul.cam.a.feed.dto.FeedParam;
import mul.cam.a.pawtens.service.PawtensService;

@RestController
public class PawtensController {
	
	@Autowired
	PawtensService service;
	
	@GetMapping(value = "/pawtens")
	public Map<String, Object> pawtens(FeedParam param){
		System.out.println("PawtensController pawtens()" + new Date());
		
		// 포텐스의 시작과 끝
		int pn = param.getPageNumber();	// 0 1 2 3 ...
		int start = 1 + (pn * 12);		// 1 6 11 16 ...
		int end = (pn + 1) * 12;		// 5 10 15 20 ...
		
		param.setStart(start);
		param.setEnd(end);
		
		List<FeedDto> list = service.pawtensList(param);
		
		// 포텐스의 총 개수
		int len = service.getAllPawtens(param);
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);  // 포텐스 리스트
		map.put("cnt", len);	// 포텐스 총 개수

		return map;
	}

}
