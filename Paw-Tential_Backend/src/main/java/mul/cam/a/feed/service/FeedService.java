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
	
	// 메인 - 모든 피드 불러오기
	public List<FeedDto> getAllFeed() {
		return dao.getAllFeed();
	}
	
	// 메인 - 특정 피드 원본 불러오기
	public FeedDto loadPost(int seq) {
		return dao.loadPost(seq);
	}
	
	// 메인 - 피드 작성하기
	public int feedWrite(FeedDto dto) {
		return dao.feedWrite(dto);
	}
	
	// 메인 - 특정 피드 수정하기
	public int feedModify(FeedDto dto) {
		return dao.feedModify(dto);
	}
	
	// 메인 - 특정 피드 삭제하기
	public int feedDelete(int seq) {
		return dao.feedDelete(seq);
	}

}
