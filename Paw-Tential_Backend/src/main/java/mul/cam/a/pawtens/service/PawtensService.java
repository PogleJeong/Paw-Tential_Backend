package mul.cam.a.pawtens.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.feed.dto.FeedDto;
import mul.cam.a.feed.dto.FeedParam;
import mul.cam.a.pawtens.dao.PawtensDao;
import mul.cam.a.pawtens.dto.PawtensDto;

@Service
@Transactional
public class PawtensService {
	
	@Autowired
	PawtensDao dao;
	
	public List<FeedDto> pawtensList(FeedParam param) {
		return dao.pawtensList(param);
	}
	
	public int getAllPawtens(FeedParam param) {
		return dao.getAllPawtens(param);
	}
	
	public boolean pawtensWrite(PawtensDto dto) {
		return dao.pawtensWrite(dto) > 0 ? true : false;
	}

}
