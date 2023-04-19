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

  @Override
  public List<CommentDto> comment() {
    return dao.comment();
  }
}
