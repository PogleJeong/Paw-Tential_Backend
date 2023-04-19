package mul.cam.a.feed.controller;

import mul.cam.a.feed.dto.FeedDto;
import mul.cam.a.feed.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController //@Controller에 @ResponseBody가 추가된 것 Json 형태로 객체 데이터를 반환
public class FeedController {

  @Autowired
  FeedService feedService;

  //모든피드 불러오기
  @GetMapping("/mainFeed")
  public List<FeedDto> mainFeed(){
    System.out.println("mainFeed baseLayout" + new Date());
    List<FeedDto> feed = feedService.feed();
    return feed;
  }
  //로그인했을때,팔로우한 피드까지 불러오기

}
