package mul.cam.a.follow.dao;

import mul.cam.a.follow.dto.FollowDto;

import java.util.List;

public interface FollowDao {

  List<FollowDto> getAllFollowId(String id);
}
