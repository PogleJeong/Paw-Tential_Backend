package mul.cam.a.bookmark.controller;

import mul.cam.a.bookmark.dto.BookmarkDto;
import mul.cam.a.bookmark.service.BookmarkService;
import mul.cam.a.comment.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class BookmarkController {

  @Autowired
  BookmarkService service;

  //bookmark 불러오기
  @GetMapping("/Bookmark")
  public List<BookmarkDto> getAllBookmark(){
    System.out.println("BookmarkController baseLayout" + new Date());
    return service.getAllBookmark();
  }

  //bookmark 저장
@PostMapping("/Bookmark")
  public void addBookmark(@RequestBody BookmarkDto bookmarkDto){
    System.out.println("BookmarkController baseLayout" + new Date());
    service.addBookmark(bookmarkDto);
}
}

