package mul.cam.a.feed.dao;



import mul.cam.a.feed.dto.FeedDto;


import java.util.List;

public interface FeedDao {


   List<FeedDto> mainFeed();

   List<FeedDto> getAllFeedByUserId(String userId);

   List<FeedDto> getFollowToUsersFeed(String id);
}
