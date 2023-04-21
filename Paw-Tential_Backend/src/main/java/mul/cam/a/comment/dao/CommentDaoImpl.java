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

  String ns = "Comment.";


  @Override
  public List<CommentDto> getAllComment(int seq) {
    return session.selectList(ns + "getAllComment",seq);
  }

  //댓글저장
  @Override
  public void addComment(CommentDto commentDto) {
    session.insert(ns + "addComment", commentDto);
  }


}
