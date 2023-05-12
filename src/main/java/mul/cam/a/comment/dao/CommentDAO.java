package mul.cam.a.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.comment.dto.CommentDto;

@Mapper
@Repository
public interface CommentDAO {
	
	// 특정 피드의 댓글 리스트 불러오기
	List<CommentDto> getCommentList(int feedSeq);
	
	// 특정 피드에 댓글 작성하기
	int writeComment(CommentDto dto);
	
	// 특정 피드의 댓글 수정하기
	int modifyComment(CommentDto dto);
	
	// 특정 피드의 댓글 삭제하기
	int deleteComment(int seq);
}