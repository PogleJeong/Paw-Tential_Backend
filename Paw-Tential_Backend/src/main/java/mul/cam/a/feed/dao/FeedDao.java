package mul.cam.a.feed.dao;


import mul.cam.a.feed.dto.FeedDto;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FeedDao {

	List<Map<String, Object>> getAllFeed();
   
	List<FeedDto> getAllFeedByUserId(String userId);

	//로그인시,팔로우피드 보이기
	List<FeedDto> getFollowToUsersFeed(String id);
   
	// 피드 작성하기
	int feedWrite(FeedDto dto);
   
	// 특정 피드 정보 불러오기
	FeedDto getFeedInfo(int seq);
   
	// 피드 수정하기
	int feedUpdate(FeedDto dto);
   
	// 피드 삭제하기
	int feedDelete(int seq);
}
