package mul.cam.a.follow.dao;

import mul.cam.a.follow.dto.FollowDto;

import java.util.List;

public interface FollowDao {

  // List<FollowDto> getAllFollowId(String id);

  List<FollowDto> getAllToUsers(String id);

  void addFollowToUser(FollowDto followDto);

  void update(FollowDto followDto);

  void delete(Integer seq);

  FollowDto getBySeq(Integer seq);
}
