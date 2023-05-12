package mul.cam.a.pawtens.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.pawtens.dao.PawtensDao;
import mul.cam.a.pawtens.dto.PawtensDto;
import mul.cam.a.pawtens.dto.PawtensLikeDto;

@Service
@Transactional
public class PawtensService {
	
	@Autowired
	PawtensDao dao;
	
	public List<Map<String, Object>> pawtensList() {
		return dao.pawtensList();
	}

	// 포텐스 작성
	public boolean pawtensWrite(PawtensDto dto) {
		return dao.pawtensWrite(dto) > 0 ? true : false;
	}
	
	// 포텐스 좋아요
	public boolean pawtensLike(PawtensLikeDto dto) {
		return dao.pawtensLike(dto) > 0 ? true : false;
	}
	
	// 포텐스 좋아요 취소
	public boolean pawtensUnLike(PawtensLikeDto dto) {
		return dao.pawtensUnLike(dto) > 0 ? true : false;
	}
	
	// 기존에 좋아요 클릭한 이력이 있는지 조사
	public boolean hasLikedPawtens(PawtensLikeDto dto) {
		return dao.hasLikedPawtens(dto) > 0 ? true : false;
	}

}