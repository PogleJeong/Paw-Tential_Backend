package mul.cam.a.comment.controller;

import mul.cam.a.comment.dto.CommentDto;
import mul.cam.a.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class CommentController {

  @Autowired
  CommentService commentService;

  //comment불러오기
  @GetMapping("/comment")
  public List<CommentDto> comment(){
    System.out.println("comment baseLayout" + new Date());
    List<CommentDto> comment = commentService.comment();
    return comment;
  }
}
