package mul.cam.a.group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.group.dao.GroupDAO;
import mul.cam.a.group.dto.CareGroupFeedDTO;
import mul.cam.a.group.dto.GroupDTO;
import mul.cam.a.group.dto.GroupFeedCommentDTO;
import mul.cam.a.group.dto.GroupFeedDTO;
import mul.cam.a.group.dto.GroupFeedLikeDTO;
import mul.cam.a.group.dto.GroupSearchParam;
import mul.cam.a.group.dto.MemberGroupDTO;
import mul.cam.a.member.dto.MemberDto;

@Service
@Transactional
public class GroupService {

	@Autowired
	GroupDAO dao;
	
	// 특정 회원의 그룹 가입 존재 여부 확인
	public int hasJoinedGroup(String id) {
		return dao.hasJoinedGroup(id);
	}
	
	// 특정 그룹 멤버수 가져오기
	public int getGroupMember(String grpName) {
		return dao.getGroupMember(grpName);
	}
	
	// 로그인 한 유저의 프로필 사진 가져오기
	public String getProfileImage(String id) {
		return dao.getProfileImage(id);
	}
	
	// 특정 그룹에 가입한 사람 프로필 가져오기
	public List<MemberDto> getGroupMemberImg(int groupId) {
		return dao.getGroupMemberImg(groupId);
	}
	
	// 특정 그룹에 가입된 상태인지 확인
	public int isMember(MemberGroupDTO dto) {
		return dao.isMember(dto);
	}
	
	// 특정 그룹의 피드 가져오기(해당 그룹에 가입 되어 있지 않을 때)
	public List<GroupFeedDTO> getGroupFeed(int grpNo) {
		return dao.getGroupFeed(grpNo);
	}
	
	// 특정 그룹의 피드 가져오기
	public List<GroupFeedDTO> getGroupAllFeed(int grpNo) {
		return dao.getGroupAllFeed(grpNo);
	}

	
	// 특정 회원이 가입한 그룹들의 모든 피드 가져오기
	public List<GroupFeedDTO> getMemberGroupsFeeds(String id) {
		return dao.getMemberGroupsFeeds(id);
	}
	
	// 그룹 생성
	public int createGroup(GroupDTO dto) {
		return dao.createGroup(dto);
	}
	
	// 그룹 생성 시, 기존에 존재하는 그룹명인지 확인
	public int checkExistingGroup(String grpName) {
		return dao.checkExistingGroup(grpName);
	}
	
	// 그룹 생성 시, MEMBER_GROUP 테이블에도 데이터 추가
	public int addMemberGroup(MemberGroupDTO dto) {
		return dao.addMemberGroup(dto);
	}
	
	// 공식 그룹 가져오기
	public GroupDTO getOfficialGroup(String memberId) {
		return dao.getOfficialGroup(memberId);
	}
	
	// 그룹 리스트 및 검색 리스트
	public List<GroupDTO> getGroupList(GroupSearchParam param) {
		return dao.getGroupList(param);
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
	
	// 특정 피드에 좋아요 클릭한 인원
	public List<GroupFeedLikeDTO> likesMember(int grpFeedNo) {
		return dao.likesMember(grpFeedNo);
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
	
	// 댓글 수정하기
	public int cmtModify(GroupFeedCommentDTO dto) {
		return dao.cmtModify(dto);
	}
	
	// 댓글 삭제하기
	public int cmtDelete(int grpCmtNo) {
		return dao.cmtDelete(grpCmtNo);
	}
	
	// 댓글 수 카운트
	public int countComment(int grpFeedNo) {
		return dao.countComment(grpFeedNo);
	}
	
	// 댓글 내용 가져오기
	public GroupFeedCommentDTO getCmtContent(int grpCmtNo) {
		return dao.getCmtContent(grpCmtNo);
	}
	
	// 돌봄 그룹 피드 리스트
	public List<CareGroupFeedDTO> getCareGroupAllFeed(int grpNo) {
		return dao.getCareGroupAllFeed(grpNo);
	}
	
	// 돌봄 그룹 특정 피드 정보
	public CareGroupFeedDTO loadCarePost(int careGrpFeedNo) {
		return dao.loadCarePost(careGrpFeedNo);
	}
	
	// 돌봄 그룹 피드 작성
	public int createCareFeed(CareGroupFeedDTO dto) {
		return dao.createCareFeed(dto);
	}
	
	// 돌봄 그룹 피드 수정
	public int modifyCareFeed(CareGroupFeedDTO dto) {
		return dao.modifyCareFeed(dto);
	}
	
	// 돌봄 그룹 피드 삭제
	public int deleteCareFeed(int careGrpFeedNo) {
		return dao.deleteCareFeed(careGrpFeedNo);
	}
	
	
}
