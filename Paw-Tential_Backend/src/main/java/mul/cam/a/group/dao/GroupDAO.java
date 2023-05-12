package mul.cam.a.group.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.group.dto.CareGroupFeedDTO;
import mul.cam.a.group.dto.GroupDTO;
import mul.cam.a.group.dto.GroupFeedCommentDTO;
import mul.cam.a.group.dto.GroupFeedDTO;
import mul.cam.a.group.dto.GroupFeedLikeDTO;
import mul.cam.a.group.dto.GroupSearchParam;
import mul.cam.a.group.dto.MemberGroupDTO;

@Mapper
@Repository
public interface GroupDAO {
	
	// 특정 회원의 그룹 가입 존재 여부 확인
	int hasJoinedGroup(String id);
	
	// 특정 그룹 멤버수 가져오기
	int getGroupMember(String grpName);
	
	// 특정 그룹에 가입된 상태인지 확인
	int isMember(MemberGroupDTO dto);
	
	// 특정 그룹의 피드 가져오기(해당 그룹에 가입 되어 있지 않을 때)
	List<GroupFeedDTO> getGroupFeed(int grpNo);
	
	// 특정 그룹의 피드 가져오기(해당 그룹에 가입 되어 있을 때)
	List<GroupFeedDTO> getGroupAllFeed(int grpNo);
	
	// 특정 회원이 가입한 그룹들의 모든 피드 가져오기
	List<GroupFeedDTO> getMemberGroupsFeeds(String id);
	
	// 그룹 생성
	int createGroup(GroupDTO dto);
	// 그룹 생성 시, 기존에 존재하는 그룹명인지 확인
	int checkExistingGroup(String grpName);
	// 그룹 생성 시, MEMBER_GROUP 테이블에도 데이터 추가
	int addMemberGroup(MemberGroupDTO dto);
	
	// 그룹 리스트 및 검색 리스트
	List<GroupDTO> getGroupList(GroupSearchParam param);
	
	// 방문수 증가
	int addVisit(int grpNo);
	
	// 그룹 가입 요청
	int groupJoinRequest(MemberGroupDTO dto);
	
	// 그룹 가입 요청 취소
	int groupJoinCancel(MemberGroupDTO dto);
	
	// 내가 가입한 그룹의 목록
	List<GroupDTO> getMyGroupList(String memberId);
	
	// 특정 그룹의 정보 가져오기
	GroupDTO getGroupInfo(int grpNo);
	
	// 특정 그룹의 리더 가져오기
	String getGroupLeader(int grpNo);
	
	// 가입 요청 승인
	int acceptJoinRequest(MemberGroupDTO dto);
	// 그룹 멤버수 증가
	int addMember(int grpNo);
	
	// 특정 그룹에 가입 요청한 인원
	List<MemberGroupDTO> getGroupJoinRequest(int grpNo);
	
	// 그룹 수정하기
	int modifyGroup(GroupDTO dto);
	
	// 그룹 탈퇴하기
	int leaveGroup(MemberGroupDTO dto);
	// 그룹 멤버수 감소
	int removeMember(int grpNo);
	
	// 그룹 삭제하기
	int deleteGroup(int grpNo);
	
	// 특정 그룹 피드 작성하기
	int createFeed(GroupFeedDTO dto);
	
	// 피드 삭제하기
	int feedDelete(int grpFeedNo);
	
	// 특정 피드 정보 불러오기
	GroupFeedDTO loadPost(int grpFeedNo);
	// 피드 수정하기
	int feedModify(GroupFeedDTO dto);
	
	// 특정 피드 좋아요 처리
	int groupFeedLike(GroupFeedLikeDTO dto);
	// 특정 피드 좋아요 취소 처리
	int groupFeedUnLike(GroupFeedLikeDTO dto);
	// 좋아요 한 적 있는지 조사
	int hasLikedGroupFeed(GroupFeedLikeDTO dto);
	
	// 댓글 리스트 가져오기
	List<GroupFeedCommentDTO> getCommentList(int grpFeedNo);
	
	// 댓글 작성하기
	int writeGrpFeedCmt(GroupFeedCommentDTO dto);
	
	// 댓글 수정하기
	int cmtModify(GroupFeedCommentDTO dto);
	
	// 댓글 삭제하기
	int cmtDelete(int grpCmtNo);
	
	// 댓글 수 카운트
	int countComment(int grpFeedNo);
	
	// 댓글 내용 가져오기
	GroupFeedCommentDTO getCmtContent(int grpCmtNo);
	
	// 돌봄 그룹 피드 리스트
	List<CareGroupFeedDTO> getCareGroupAllFeed(int grpNo);
	// 돌봄 그룹 특정 피드 정보
	CareGroupFeedDTO loadCarePost(int careGrpFeedNo);
	// 돌봄 그룹 피드 작성
	int createCareFeed(CareGroupFeedDTO dto);
	// 돌봄 그룹 피드 수정
	int modifyCareFeed(CareGroupFeedDTO dto);
	// 돌봄 그룹 피드 삭제
	int deleteCareFeed(int careGrpFeedNo);
	
}
