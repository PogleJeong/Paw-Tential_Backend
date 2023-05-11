package mul.cam.a.pawtens.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.pawtens.dto.PawtensDto;
import mul.cam.a.pawtens.dto.PawtensLikeDto;

@Mapper
@Repository
public interface PawtensDao {

	List<Map<String, Object>> pawtensList();
	
	// 포텐스 작성
	int pawtensWrite(PawtensDto dto);
	
	// 포텐스 좋아요
	int pawtensLike(PawtensLikeDto dto);
	
	// 포텐스 좋아요 취소
	int pawtensUnLike(PawtensLikeDto dto);
	
	// 기존에 좋아요 클릭한 이력이 있는지 조사
	int hasLikedPawtens(PawtensLikeDto dto);
	
}
