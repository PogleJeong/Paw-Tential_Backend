package mul.cam.a.follow.service;

import mul.cam.a.follow.dto.FollowDto;

import java.util.List;

public interface FollowService {
  List<FollowDto> getAllFollowId(String id);

  List<FollowDto> getAllToUsers(String userId);

  void addFollowToUser(FollowDto followDto);

  void updateFollow(Integer seq, FollowDto followDto);

  void deleteFollow(Integer seq);
}
