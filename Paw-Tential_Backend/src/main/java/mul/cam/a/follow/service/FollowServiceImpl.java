package mul.cam.a.follow.service;

import mul.cam.a.follow.dao.FollowDao;
import mul.cam.a.follow.dto.FollowDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpl implements  FollowService{

  @Autowired
  FollowDao dao;
  @Override
  public List<FollowDto> getAllFollowId(String id) {
    return dao.getAllFollowId(id);
  }
}
