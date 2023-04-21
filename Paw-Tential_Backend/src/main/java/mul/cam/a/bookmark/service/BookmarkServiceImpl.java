package mul.cam.a.bookmark.service;

import mul.cam.a.bookmark.dao.BookmarkDao;
import mul.cam.a.bookmark.dto.BookmarkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkServiceImpl implements BookmarkService{

  @Autowired
  BookmarkDao dao;
  @Override
  public List<BookmarkDto> getAllBookmark() {
    return dao.getAllBookmark();
  }

  //저장
  @Override
  public void addBookmark(BookmarkDto bookmarkDto) {
    dao.addBookmark(bookmarkDto);
  }
}
