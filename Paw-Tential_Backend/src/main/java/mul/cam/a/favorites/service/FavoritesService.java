package mul.cam.a.favorites.service;

import mul.cam.a.favorites.dto.FavoritesDto;

import java.util.List;

public interface FavoritesService {
  List<FavoritesDto> favorites();

  //좋아요 추가
  int addFavorites(FavoritesDto favoritesDto);

  //좋아요 취소
  void deleteFavorites(Integer seq);

}
