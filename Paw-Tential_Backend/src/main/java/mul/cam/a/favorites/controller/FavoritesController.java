package mul.cam.a.favorites.controller;

import mul.cam.a.favorites.dto.FavoritesDto;
import mul.cam.a.favorites.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class FavoritesController {

  @Autowired
  private FavoritesService favoritesService;

  //좋아요 저장..으로 만들어야하는데 불러오기가 됬네
  @GetMapping("/aaa")
  public List<FavoritesDto> mainFeed(){
    System.out.println("mainFeed baseLayout" + new Date());
    List<FavoritesDto> favorites = favoritesService.favorites();

    return favorites;
  }
}
