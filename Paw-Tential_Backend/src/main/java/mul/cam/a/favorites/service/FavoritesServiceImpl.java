package mul.cam.a.favorites.service;

import mul.cam.a.favorites.dao.FavoritesDao;
import mul.cam.a.favorites.dto.FavoritesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesServiceImpl implements FavoritesService{

  @Autowired
  FavoritesDao dao;

  @Override
  public List<FavoritesDto> favorites() {

    return dao.favorites();
  }

  @Override
  public void addFavorites(FavoritesDto favoritesDto) {
    dao.addFavorites(favoritesDto);

  }
}
