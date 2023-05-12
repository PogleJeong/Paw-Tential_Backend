package mul.cam.a.comment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.comment.dto.CommentDto;
import mul.cam.a.comment.service.CommentService;

@RestController
public class CommentController {

  @Autowired
  CommentService service;
  
  // 특정 피드의 댓글 리스트 불러오기
  @GetMapping("/home/getCommentList")
  public Map<String, Object> getCommentList(int feedSeq){
	  System.out.println(feedSeq);
	  Map<String, Object> map = new HashMap<>();
	  map.put("commentList", service.getCommentList(feedSeq));
	  System.out.println(service.getCommentList(feedSeq));
	  return map;
  }
  
  // 특정 피드에 댓글 작성하기
  @PostMapping("/home/writeComment")
  public String writeComment(CommentDto dto) {
	  System.out.println(dto.toString());
	  return service.writeComment(dto) > 0 ? "댓글이 등록 되었습니다." : "댓글 등록에 실패하였습니다.";
  }
  
  // 특정 피드의 댓글 수정하기
  @PostMapping("/home/modifyComment")
  public String modifyComment(CommentDto dto) {
	  return service.modifyComment(dto) > 0 ? "success" : "fail";
  }
  
  // 특정 피드의 댓글 삭제하기
  @GetMapping("/home/deleteComment")
  public String deleteComment(int seq) {
	  return service.deleteComment(seq) > 0 ? "댓글이 삭제되었습니다." : "댓글 삭제에 실패하였습니다.";
  }
 
  
}