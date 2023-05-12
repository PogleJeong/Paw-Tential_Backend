package mul.cam.a.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.feed.dto.FeedDto;
import mul.cam.a.feed.dto.FeedParam;
import mul.cam.a.member.dto.MemberDto;
import mul.cam.a.search.dao.SearchDao;

@Service
@Transactional
public class SearchService {
	
	@Autowired
	SearchDao dao;
	
	public List<FeedDto> searchList(FeedParam param) {
		return dao.searchList(param);
	}
	
	public int getAllResult(FeedParam param) {
		return dao.getAllResult(param);
	}
	
	public List<MemberDto> searchUserList(FeedParam param) {
		return dao.searchUserList(param);
	}
	
	public int getAllUser(FeedParam param) {
		return dao.getAllUser(param);
	}
	
}
