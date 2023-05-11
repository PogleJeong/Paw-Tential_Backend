package mul.cam.a.feed.dao;


import mul.cam.a.feed.dto.FeedDto;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FeedDao {
	
	// 메인 - 모든 피드 불러오기
	List<FeedDto> getAllFeed();
	
	// 메인 - 특정 피드 원본 불러오기
	FeedDto loadPost(int seq);
	
	// 메인 - 피드 작성하기
	int feedWrite(FeedDto dto);
	
	// 메인 - 특정 피드 수정하기
	int feedModify(FeedDto dto);
	
	// 메인 - 특정 피드 삭제하기
	int feedDelete(int seq);
	
}
