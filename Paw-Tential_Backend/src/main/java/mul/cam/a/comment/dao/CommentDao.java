package mul.cam.a.comment.dao;

import mul.cam.a.comment.dto.CommentDto;
import mul.cam.a.follow.dto.FollowDto;

import java.util.List;

public interface CommentDao {

  // 댓글불러오기
  List<CommentDto> getAllComment(int seq);

  //댓글저장하기
  void addComment(CommentDto commentDto);
}
