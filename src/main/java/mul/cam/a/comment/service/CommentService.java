package mul.cam.a.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.comment.dao.CommentDAO;
import mul.cam.a.comment.dto.CommentDto;

@Service
@Transactional
public class CommentService {

	@Autowired
	CommentDAO dao;
	
	// 특정 피드의 댓글 리스트 불러오기
	public List<CommentDto> getCommentList(int feedSeq) {
		return dao.getCommentList(feedSeq);
	}
	
	// 특정 피드에 댓글 작성하기
	public int writeComment(CommentDto dto) {
		return dao.writeComment(dto);
	}
	
	// 특정 피드의 댓글 수정하기
	public int modifyComment(CommentDto dto) {
		return dao.modifyComment(dto);
	}
	
	// 특정 피드의 댓글 삭제하기
	public int deleteComment(int seq) {
		return dao.deleteComment(seq);
	}
}