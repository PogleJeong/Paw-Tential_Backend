package mul.cam.a.pawtens.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.feed.dto.FeedDto;
import mul.cam.a.feed.dto.FeedParam;
import mul.cam.a.pawtens.dto.PawtensDto;

@Mapper
@Repository
public interface PawtensDao {

	List<FeedDto> pawtensList(FeedParam param);
	
	int getAllPawtens(FeedParam param);
	
	int pawtensWrite(PawtensDto dto);
}
