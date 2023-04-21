package mul.cam.a.bookmark.service;

import mul.cam.a.bookmark.dto.BookmarkDto;

import java.util.List;

public interface BookmarkService {

  List<BookmarkDto> getAllBookmark();

  void addBookmark(BookmarkDto bookmarkDto);
}
