package mul.cam.a.favorites.controller;

import mul.cam.a.favorites.dto.FavoritesDto;
import mul.cam.a.favorites.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class FavoritesController {

  @Autowired
  FavoritesService service;
  
  // 좋아요 로직
  @GetMapping("/home/like")
  public String like(FavoritesDto dto) {
	  System.out.println(dto.toString());
	  // 좋아요 클릭한적 있는지 조사 후,  이력이 없으면 반영하고 이력이 있으면 취소
	  int count = service.hasLiked(dto);
	  // 이력이 없으면 반영
	  if(count == 0) {
		  return service.like(dto) > 0 ? "좋아요가 반영되었습니다." : "좋아요 반영에 실패하였습니다.";
	  } else {
		  return service.unLike(dto) > 0 ? "좋아요가 취소되었습니다." : "좋아요 취소에 실패하였습니다.";
	  }
  }
  
}
