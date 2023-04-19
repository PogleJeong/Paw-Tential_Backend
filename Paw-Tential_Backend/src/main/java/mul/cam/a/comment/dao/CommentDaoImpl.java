package mul.cam.a.comment.dao;

import mul.cam.a.comment.dto.CommentDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao{

@Autowired
SqlSession session;

  @Override
  public List<CommentDto> comment() {
    return session.selectList("Comment.getAllComment");
  }
}
