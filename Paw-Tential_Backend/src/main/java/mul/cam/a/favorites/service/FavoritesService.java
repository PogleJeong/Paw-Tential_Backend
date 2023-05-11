package mul.cam.a.favorites.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.favorites.dao.FavoritesDAO;
import mul.cam.a.favorites.dto.FavoritesDto;

@Service
@Transactional
public class FavoritesService {

	@Autowired
	FavoritesDAO dao;
	
	// 좋아요 클릭한적 있는지 조사 후,  이력이 없으면 반영하고 이력이 있으면 취소
	public int hasLiked(FavoritesDto dto) {
		return dao.hasLiked(dto);
	}
	public int like(FavoritesDto dto) {
		return dao.like(dto);
	}
	public int unLike(FavoritesDto dto) {
		return dao.unLike(dto);
	}
	
}
