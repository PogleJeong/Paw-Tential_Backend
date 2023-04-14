package mul.cam.a.follow.service;

import mul.cam.a.follow.dto.FollowDto;

import java.util.List;

public interface FollowService {
  List<FollowDto> getAllFollowId(String id);

}
