package mul.cam.a.comment.service;

import mul.cam.a.comment.dao.CommentDao;
import mul.cam.a.comment.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

  @Autowired
  CommentDao dao;

 //댓글불러오기
  @Override
  public List<CommentDto> getAllComment(int seq) {
    return dao.getAllComment(seq);
  }
//댓글저장
  @Override
  public void addComment(CommentDto commentDto) {
    dao.addComment(commentDto);
  }
}
