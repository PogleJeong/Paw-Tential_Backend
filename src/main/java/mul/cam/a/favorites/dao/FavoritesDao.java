package mul.cam.a.favorites.dao;

import mul.cam.a.favorites.dto.FavoritesDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FavoritesDao {
  List<FavoritesDto> favorites();

  //좋아요 추가
  int addFavorites(FavoritesDto favoritesDto);

  //좋아요 취소
  void deleteFavorites(Integer seq);

}
