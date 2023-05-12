package mul.cam.a.myfeed.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.admin.dto.PageParam;
import mul.cam.a.feed.dto.FeedDto;
import mul.cam.a.member.dto.MemberDto;
import mul.cam.a.myfeed.dao.MyfeedDao;
import mul.cam.a.myfeed.dto.FollowDto;

@Service
@Transactional
public class MyfeedService {
	
	@Autowired
	MyfeedDao dao;
	
	public List<FeedDto> Myfeed(String id) {
		return dao.getMyFeed(id);
	}
	
	public int getFollower (String id) {
		return dao.getFollower(id);
	}
	
	public int getFollowing (String id) {
		return dao.getFollowing(id);
	}
	
	public boolean follow (FollowDto dto) {
		int n = dao.follow(dto);
		return n>0?true:false;
	}
	
	public boolean unfollow (FollowDto dto) {
		int n = dao.unfollow(dto);
		return n>0?true:false;
	}
	

	public List<String> followerList(String id) {
		return dao.followerList(id);
	}
	
	public List<String> followingList(String id) {
		return dao.followingList(id);
	}
	
	public boolean isFollowing(String follower_id, String following_id) {
		int n =  dao.isFollowing(follower_id, following_id);
		return n>0?true:false;
	}
	
	public List<MemberDto> searchMember(PageParam param){
		return dao.searchMember(param);
	}
	
	public boolean editMember(MemberDto dto) {
		
		int n =  dao.editMember(dto);

		return n>0?true:false;
	}
}
