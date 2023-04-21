package mul.cam.a.myfeed.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.member.dto.MemberDto;

@Mapper
@Repository
public interface MyfeedDao {
	
	MemberDto userInfo(String id);
	

	

}
