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

  @Override
  public List<FollowDto> getAllToUsers(String userId) {
    return dao.getAllToUsers(userId);
  }

  @Override
  public void addFollowToUser(FollowDto followDto) {
    dao.addFollowToUser(followDto);
  }

  @Override
  public void updateFollow(Integer seq, FollowDto followDto) {
    FollowDto follow = dao.getBySeq(seq);
    if (follow != null) {
      dao.update(followDto);
    }
  }

  @Override
  public void deleteFollow(Integer seq) {
    dao.delete(seq);
  }
}
