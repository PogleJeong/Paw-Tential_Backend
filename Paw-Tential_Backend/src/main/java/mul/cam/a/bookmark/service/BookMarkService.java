package mul.cam.a.bookmark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.bookmark.dao.BookMarkDAO;
import mul.cam.a.bookmark.dto.BookmarkDto;

@Service
@Transactional
public class BookMarkService {
	
	@Autowired
	BookMarkDAO dao;
	
	// 기존에 북마크 한 적 있는지 조사
	public int hasBookMark(BookmarkDto dto) {
		return dao.hasBookMark(dto);
	}
	
	// 북마크 반영
	public int bookMark(BookmarkDto dto) {
		return dao.bookMark(dto);
	}
	
	// 북마크 취소
	public int unBookMark(BookmarkDto dto) {
		return dao.unBookMark(dto);
	}
	
}
