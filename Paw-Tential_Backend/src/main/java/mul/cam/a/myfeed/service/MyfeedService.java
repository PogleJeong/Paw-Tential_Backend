package mul.cam.a.myfeed.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.feed.dto.FeedDto;
import mul.cam.a.myfeed.dao.MyfeedDao;

@Service
@Transactional
public class MyfeedService {
	
	@Autowired
	MyfeedDao dao;
	
	public List<FeedDto> Myfeed(String id) {
		return dao.getMyFeed(id);
	}
	

}
