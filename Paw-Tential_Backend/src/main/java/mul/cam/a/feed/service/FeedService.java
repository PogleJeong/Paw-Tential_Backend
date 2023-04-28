package mul.cam.a.feed.service;

import mul.cam.a.feed.dto.FeedDto;
import mul.cam.a.follow.dto.FollowDto;

import java.util.List;

public interface FeedService {
  List<FeedDto> feed();
  List<FeedDto> getAllFeedByUserId(String userId);
  /*
 void getFollowToUsersFeed(String toUser);
 void getFollowToUsersFeed(String toUser, FollowDto followdto);
*/
  List<FeedDto>getFollowToUsersFeed(String id);
}
