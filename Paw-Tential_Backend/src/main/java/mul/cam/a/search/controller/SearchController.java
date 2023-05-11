package mul.cam.a.search.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.feed.dto.FeedDto;
import mul.cam.a.feed.dto.FeedParam;
import mul.cam.a.member.dto.MemberDto;
import mul.cam.a.search.service.SearchService;

@RestController
public class SearchController {
	
	@Autowired
	SearchService service;
	
	@GetMapping(value = "/search")
	public Map<String, Object> search(FeedParam param){
		System.out.println("SearchController search()" + new Date());
		
		// 검색 시작과 끝
		int pn = param.getPageNumber();	// 0 1 2 3 ...
		int start = 1 + (pn * 12);		// 1 6 11 16 ...
		int end = (pn + 1) * 12;		// 5 10 15 20 ...
		
		param.setStart(start);
		param.setEnd(end);
		
		List<FeedDto> list = service.searchList(param);
		int len = service.getAllResult(param);
		
		List<MemberDto> userlist = service.searchUserList(param);
		int userlen = service.getAllUser(param);
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len);
		map.put("userlist", userlist);
		map.put("usercnt", userlen);

		return map;
	}

}
