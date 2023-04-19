package mul.cam.a.comment.service;


import mul.cam.a.comment.dto.CommentDto;

import java.util.List;

public interface CommentService {


  List<CommentDto> getAllComment(int seq);

  void addComment(CommentDto commentDto);
}
