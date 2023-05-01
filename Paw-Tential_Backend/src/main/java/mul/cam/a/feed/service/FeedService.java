package mul.cam.a.feed.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.feed.dao.FeedDao;
import mul.cam.a.feed.dto.FeedDto;

@Service
@Transactional
public class FeedService {
	
	@Autowired
	FeedDao dao;
	
	public List<Map<String, Object>> feed() {
		return dao.getAllFeed();
	}

	public List<FeedDto> getFollowToUsersFeed(String id) {
		return dao.getFollowToUsersFeed(id);
	}
	
	// 피드 작성하기
	public String feedWrite(FeedDto dto) {
		return dao.feedWrite(dto) > 0 ? "피드 작성 완료" : "피드 작성 실패";
	}
	
	// 특정 피드 정보 불러오기
	public FeedDto getFeedInfo(int seq) {
		return dao.getFeedInfo(seq);
	}
	
	// 피드 수정하기
	public String feedUpdate(FeedDto dto) {
		return dao.feedUpdate(dto) > 0 ? "피드 수정 완료" : "피드 수정 실패";
	}
	
	// 피드 삭제하기
	public String feedDelete(int seq) {
		return dao.feedDelete(seq) > 0 ? "피드 삭제 완료" : "피드 삭제 실패";
	}

}
