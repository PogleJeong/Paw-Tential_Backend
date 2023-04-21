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
  FeedService service;

  //모든피드 불러오기
  @GetMapping("/mainFeed")
  public List<FeedDto> mainFeed(){
    System.out.println("mainFeed baseLayout" + new Date());
    List<FeedDto> feed = service.feed();
    return feed;
  }
  //로그인후,팔로우한 피드까지 불러오기
@GetMapping("/{id}/mainFeed")
  public List<FeedDto> getFollowToUsersFeed(@PathVariable String id){
    System.out.println("getFollowToUsersFeed baseLayout" + new Date());
  return service.getFollowToUsersFeed(id);

}
}
