package mul.cam.a.bookmark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.bookmark.dto.BookmarkDto;
import mul.cam.a.bookmark.service.BookMarkService;

@RestController
public class BookmarkController {

	@Autowired
	BookMarkService service;
	
	// 북마크 한 이력이 있는지 조사
	@GetMapping("/home/hasBookMark")
	public int hasBookMark(BookmarkDto dto) {
		return service.hasBookMark(dto);
	}
	
	// 북마크 처리
	@GetMapping("/home/bookMark")
	public String bookMark(BookmarkDto dto) {
		
		// 이력 조사
		int count = service.hasBookMark(dto);
		
		if(count == 0) {
			return service.bookMark(dto) > 0 ? "bookMark" : "bookMark Fail";
		} else {
			return service.unBookMark(dto) > 0 ? "unBookMark" : "unBookMark Fail";					
		}
		
	}

}
