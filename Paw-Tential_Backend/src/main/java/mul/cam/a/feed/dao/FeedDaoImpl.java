package mul.cam.a.feed.dao;

import mul.cam.a.feed.dto.FeedDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeedDaoImpl implements FeedDao{

  @Autowired
  SqlSession session;

  @Override
  public List<FeedDto> mainFeed() {
    return session.selectList("Feed.getAllFeed");
  }
}
