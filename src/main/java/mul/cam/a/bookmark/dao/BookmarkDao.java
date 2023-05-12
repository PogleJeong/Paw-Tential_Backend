package mul.cam.a.bookmark.dao;

import mul.cam.a.bookmark.dto.BookmarkDto;

import java.util.List;

public interface BookmarkDao {
  List<BookmarkDto> getAllBookmark();

  //북마크저장
  void addBookmark(BookmarkDto bookmarkDto);
}
