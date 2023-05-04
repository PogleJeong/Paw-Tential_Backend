package mul.cam.a.myfeed.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.feed.dto.FeedDto;
import mul.cam.a.myfeed.service.MyfeedService;

@RestController // @Controller에 @ResponseBody가 추가된 것 Json 형태로 객체 데이터를 반환
public class MyfeedController {
	@Autowired
	MyfeedService service;

	
	//모든피드 불러오기
	@GetMapping(value = "Myfeed")
	public List<FeedDto> Myfeed(String id) {
		System.out.println("myfeed 진입 " + new Date());
		List<FeedDto> myfeed = service.Myfeed(id);
		return myfeed;
	}
}
