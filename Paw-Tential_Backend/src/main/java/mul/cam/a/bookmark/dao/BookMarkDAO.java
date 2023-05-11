package mul.cam.a.bookmark.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.bookmark.dto.BookmarkDto;

@Mapper
@Repository
public interface BookMarkDAO {
	// 기존에 북마크 한 적 있는지 조사
	int hasBookMark(BookmarkDto dto);
	
	// 북마크 반영
	int bookMark(BookmarkDto dto);
	
	// 북마크 취소
	int unBookMark(BookmarkDto dto);
}
