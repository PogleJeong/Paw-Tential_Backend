package mul.cam.a.search.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.feed.dto.FeedDto;
import mul.cam.a.feed.dto.FeedParam;
import mul.cam.a.member.dto.MemberDto;

@Mapper
@Repository
public interface SearchDao {

	List<FeedDto> searchList(FeedParam param);
	
	int getAllResult(FeedParam param);
	
	List<MemberDto> searchUserList(FeedParam param);
	
	int getAllUser(FeedParam param);
	
}
