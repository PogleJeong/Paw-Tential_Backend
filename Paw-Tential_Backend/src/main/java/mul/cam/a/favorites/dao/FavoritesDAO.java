package mul.cam.a.favorites.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.favorites.dto.FavoritesDto;

@Mapper
@Repository
public interface FavoritesDAO {

	int hasLiked(FavoritesDto dto);
	int like(FavoritesDto dto);
	int unLike(FavoritesDto dto);
	
}
