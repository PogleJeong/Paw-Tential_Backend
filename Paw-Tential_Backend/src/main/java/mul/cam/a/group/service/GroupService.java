package mul.cam.a.group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.group.dao.GroupDAO;
import mul.cam.a.group.dto.GroupDTO;
import mul.cam.a.group.dto.GroupFeedCommentDTO;
import mul.cam.a.group.dto.GroupFeedDTO;
import mul.cam.a.group.dto.GroupFeedLikeDTO;
import mul.cam.a.group.dto.MemberGroupDTO;

@Service
@Transactional
public class GroupService {

	@Autowired
	GroupDAO dao;
	
	// 특정 회원의 그룹 가입 존재 여부 확인
	public int hasJoinedGroup(String id) {
		return dao.hasJoinedGroup(id);
	}
	
	// 특정 그룹의 피드 가져오기
	public List<GroupFeedDTO> getGroupFeed(int grpNo) {
		return dao.getGroupFeed(grpNo);
	}
	
	// 특정 회원이 가입한 그룹들의 모든 피드 가져오기
	public List<GroupFeedDTO> getMemberGroupsFeeds(String id) {
		return dao.getMemberGroupsFeeds(id);
	}
	
	// 그룹 생성
	public int createGroup(GroupDTO dto) {
		return dao.createGroup(dto);
	}
	
	// 그룹 생성 시, MEMBER_GROUP 테이블에도 데이터 추가
	public int addMemberGroup(MemberGroupDTO dto) {
		return dao.addMemberGroup(dto);
	}
	
	// 그룹 검색
	public List<GroupDTO> searchGroup(MemberGroupDTO dto) {
		return dao.searchGroup(dto);
	}
	
	// 그룹 방문수 증가
	public int addVisit(int grpNo) {
		return dao.addVisit(grpNo);
	}
	
	// 그룹 가입 요청
	public int groupJoinRequest(MemberGroupDTO dto) {
		return dao.groupJoinRequest(dto);
	}
	
	// 그룹 가입 요청 취소
	public int groupJoinCancel(MemberGroupDTO dto) {
		return dao.groupJoinCancel(dto);
	}
	
	// 그룹 가입 요청 승인
	public int acceptJoinRequest(MemberGroupDTO dto) {
		return dao.acceptJoinRequest(dto);
	}
	// 그룹 멤버수 증가
	public int addMember(int grpNo) {
		return dao.addMember(grpNo);
	}
	
	// 내가 가입한 그룹의 목록
	public List<GroupDTO> getMyGroupList(String memberId) {
		return dao.getMyGroupList(memberId);
	};
	
	// 특정 그룹의 정보 가져오기
	public GroupDTO getGroupInfo(int grpNo) {
		return dao.getGroupInfo(grpNo);
	}
	
	// 특정 그룹의 리더
	public String getGroupLeader(int grpNo) {
		return dao.getGroupLeader(grpNo);
	}
	
	// 특정 그룹에 가입 요청한 인원
	public List<MemberGroupDTO> getGroupJoinRequest(int grpNo) {
		return dao.getGroupJoinRequest(grpNo);
	}
	
	// 그룹 수정하기
	public int modifyGroup(GroupDTO dto) {
		return dao.modifyGroup(dto);
	}
	
	// 그룹 탈퇴하기
	public int leaveGroup(MemberGroupDTO dto) {
		return dao.leaveGroup(dto);
	}
	// 그룹 멤버수 감소
	public int removeMember(int grpNo) {
		return dao.removeMember(grpNo);
	}
	
	// 그룹 삭제하기
	public int deleteGroup(int grpNo) {
		return dao.deleteGroup(grpNo);
	}
	
	// 특정 그룹 피드 작성하기
	public int createFeed(GroupFeedDTO dto) {
		return dao.createFeed(dto);
	}
	
	// 특정 피드 정보 불러오기
	public GroupFeedDTO loadPost(int grpFeedNo) {
		return dao.loadPost(grpFeedNo);
	}
	// 피드 수정하기
	public int feedModify(GroupFeedDTO dto) {
		return dao.feedModify(dto);
	}
	
	// 피드 삭제 하기
	public int feedDelete(int grpFeedNo) {
		return dao.feedDelete(grpFeedNo);
	}
	
	// 특정 피드 좋아요 처리
	public int groupFeedLike(GroupFeedLikeDTO dto) {
		return dao.groupFeedLike(dto);
	}
	// 특정 피드 좋아요 취소 처리
	public int groupFeedUnLike(GroupFeedLikeDTO dto) {
		return dao.groupFeedUnLike(dto);
	}
	// 좋아요 한 적 있는지 조사
	public int hasLikedGroupFeed(GroupFeedLikeDTO dto) {
		return dao.hasLikedGroupFeed(dto);
	}
	
	// 댓글 리스트 가져오기
	public List<GroupFeedCommentDTO> getCommentList(int grpFeedNo) {
		return dao.getCommentList(grpFeedNo);
	}
	
	// 댓글 작성하기
	public int writeGrpFeedCmt(GroupFeedCommentDTO dto) {
		return dao.writeGrpFeedCmt(dto);
	}
	
	// 댓글 삭제하기
	public int cmtDelete(int grpCmtNo) {
		return dao.cmtDelete(grpCmtNo);
	}
	
	// 댓글 수 카운트
	public int countComment(int grpFeedNo) {
		return dao.countComment(grpFeedNo);
	}
	
	
}
