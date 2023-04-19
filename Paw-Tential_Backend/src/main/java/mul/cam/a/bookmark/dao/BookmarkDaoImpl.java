package mul.cam.a.bookmark.dao;

import mul.cam.a.bookmark.dto.BookmarkDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookmarkDaoImpl implements BookmarkDao{

  @Autowired
  SqlSession session;

  String ns = "Bookmark.";
  @Override
  public List<BookmarkDto> getAllBookmark() {
    return session.selectList(ns + "getAllBookmark");
  }

  //bookmark저장
  @Override
  public void addBookmark(BookmarkDto bookmarkDto) {
    session.insert(ns + "addBookmark",bookmarkDto);

  }
}
