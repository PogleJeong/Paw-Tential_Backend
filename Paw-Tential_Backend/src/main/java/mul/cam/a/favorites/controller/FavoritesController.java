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
  private FavoritesService service;

  //좋아요 불러오기
  @GetMapping("/Favorites")
  public List<FavoritesDto> mainFeed(){
    System.out.println("mainFeed baseLayout" + new Date());
    List<FavoritesDto> favorites = service.favorites();

    return favorites;
  }
  
  //좋아요 저장
  @PostMapping("/Favorites")
  public Integer addFavorites(@RequestBody FavoritesDto favoritesDto){
    System.out.println("FavoritesController baseLayout" + new Date() + favoritesDto);
    service.addFavorites(favoritesDto);
    return favoritesDto.getSeq();
  }

  //좋아요 취소
  @DeleteMapping("/{seq}/Favorites")
  public void deleteFavorites(@PathVariable Integer seq){
    System.out.println("FavoritesController delete baseLayout" + new Date() + seq);
    service.deleteFavorites(seq);

  }
}
