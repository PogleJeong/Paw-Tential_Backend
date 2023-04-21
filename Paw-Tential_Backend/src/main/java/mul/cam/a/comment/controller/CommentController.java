package mul.cam.a.comment.controller;

import mul.cam.a.comment.dto.CommentDto;
import mul.cam.a.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class CommentController {

  @Autowired
  CommentService service;

  //comment불러오기
  @GetMapping("/{seq}/Comment")
  public List<CommentDto> getAllComment(@PathVariable int seq){
    System.out.println("CommentController baseLayout" + new Date());
    return service.getAllComment(seq);
  }

  //comment 저장
@PostMapping("/Comment")
  public void addComment(@RequestBody CommentDto commentDto){
    System.out.println("CommentController baseLayout" + new Date());
    service.addComment(commentDto);
}
}
