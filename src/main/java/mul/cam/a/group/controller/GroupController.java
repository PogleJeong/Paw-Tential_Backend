package mul.cam.a.group.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import mul.cam.a.group.dto.CareGroupFeedDTO;
import mul.cam.a.group.dto.GroupDTO;
import mul.cam.a.group.dto.GroupFeedCommentDTO;
import mul.cam.a.group.dto.GroupFeedDTO;
import mul.cam.a.group.dto.GroupFeedLikeDTO;
import mul.cam.a.group.dto.GroupSearchParam;
import mul.cam.a.group.dto.MemberGroupDTO;
import mul.cam.a.group.service.GroupService;
import mul.cam.a.group.util.FileUtil;

@RestController
public class GroupController {

	@Autowired
	GroupService service;
	
	// 가입 그룹의 존재 여부
	@GetMapping("/group/hasJoinedGroup")
	public boolean hasJoinedGroup(String memberId) {
		return service.hasJoinedGroup(memberId) > 0 ? true : false;
	}
	
	// 특정 그룹 회원 수 가져오기
	@GetMapping("/group/getGroupMember")
	public int getGroupMember(String grpName) {
		System.out.println(grpName);
		return service.getGroupMember(grpName);
	}
	
	// 뉴스피드
	@GetMapping("/group/newsFeed")
	public Map<String, Object> newsFeed(String memberId) {
		Map<String, Object> map = new HashMap<>();
		map.put("newsFeed", service.getMemberGroupsFeeds(memberId));
		return map != null ? map : null;
	}
	
	
	// 특정 그룹 방문 시 로직
	@PostMapping("/group/isMember")
	public Map<String, Object> isMember(MemberGroupDTO dto) {
		
		Map<String, Object> map = new HashMap<>();
		
		// 해당 그룹의 방문수 증가
		service.addVisit(dto.getGroupId());
		
		// 해당 그룹에 가입된 상태인지 조사
		int count = service.isMember(dto);
		map.put("count", count);
		
		if(count > 0) {
			// 해당 그룹에 가입된 상태이면 모든 피드 보여주기
			map.put("groupAllFeed", service.getGroupAllFeed(dto.getGroupId()));
			return map;
		} else {
			// 해당 그룹에 가입된 상태가 아니면 '전체 공개' 인 피드만 보여주기
			map.put("groupFeed", service.getGroupFeed(dto.getGroupId()));
			return map;
		}
	}
	
	// 기존에 존재하는 그룹명인지 확인
	@GetMapping("/group/checkExistingGroup")
	public String checkExistingGroup(String grpName) {
		return service.checkExistingGroup(grpName) > 0 ? "NO" : "YES";
	}
	
	
	// 그룹 생성
	@PostMapping("/group/createGroup")
	public String createGroup(GroupDTO dto, MemberGroupDTO memberGroupDTO,
													@RequestParam("uploadFile") MultipartFile uploadFile,
													HttpServletRequest req) throws IOException {
		
			String path = req.getServletContext().getRealPath("/upload/group");
			
			String fileName = uploadFile.getOriginalFilename();
			String newFileName = FileUtil.getNewFileName(fileName);
			dto.setImage(newFileName);
			
			// DB에 파일 경로 저장
			String filePath = "../upload/group/" + newFileName;
			System.out.println(filePath);
			dto.setGrpImage(filePath);
			
			File file = new File(path + "/" + newFileName);
			
			FileUtils.writeByteArrayToFile(file, uploadFile.getBytes());
			
			int answer = service.createGroup(dto);
			System.out.println(dto.toString());
			
			memberGroupDTO.setMemberId(dto.getGrpLeader());
			memberGroupDTO.setGroupName(dto.getGrpName());
			memberGroupDTO.setGroupId(dto.getGrpNo());
			
			// MEMBER_GROUP 테이블에 데이터 추가
			service.addMemberGroup(memberGroupDTO);
			
			return answer > 0 ? "그룹이 생성되었습니다." : "그룹 생성에 실패하였습니다.";
	}
	
	// 그룹 리스트 및 검색 결과
	@GetMapping("/group/getGroupList")
	public Map<String, Object> getAllGroupList(GroupSearchParam param) {
		System.out.println(param.toString());
		Map<String, Object> map = new HashMap<>();
		map.put("groupList", service.getGroupList(param));
		return map;
	}

	
	// 그룹 가입 요청
	@PostMapping("/group/groupJoinRequest")
	public String groupJoinRequest(MemberGroupDTO dto) {
		int count = service.groupJoinRequest(dto);
		return count > 0 ? "그룹 가입이 요청되었습니다" : "그룹 가입 요청에 실패했습니다.";
	}
	
	// 그룹 가입 요청 취소
	@PostMapping("/group/groupJoinCancel")
	public String groupJoinCancel(MemberGroupDTO dto) {
		int count = service.groupJoinCancel(dto);
		return count > 0 ? "그룹 가입 요청이 취소 되었습니다" : "그룹 가입 요청 취소에 실패했습니다.";
	}
	
	// 내가 가입한 그룹의 목록
	@GetMapping("/group/getMyGroupList")
	public Map<String, Object> getMyGroupList(String memberId) {
		System.out.println(memberId);
		Map<String, Object> map = new HashMap<>();
		map.put("myGroupList", service.getMyGroupList(memberId));
		return map;
	}
	
	// 특정 그룹의 정보 가져오기
	@GetMapping("/group/getGroupInfo")
	public GroupDTO getGroupInfo(int grpNo) {
		System.out.println(grpNo);
		GroupDTO dto = service.getGroupInfo(grpNo);
		System.out.println(dto.toString());
		return dto;
	}
	
	// 특정 그룹의 리더
	@GetMapping("/group/getGroupLeader")
	public String getGroupLeader(int grpNo) {
		return service.getGroupLeader(grpNo);
	}
	
	// 특정 그룹에 가입 요청한 인원
	@GetMapping("/group/getGroupJoinRequest")
	public Map<String, Object> getGroupJoinRequest(int grpNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("joinRequestList", service.getGroupJoinRequest(grpNo));
		return map; 
	}
	
	// 그룹 가입 요청 승인
	@PostMapping("/group/acceptJoinRequest")
	public String acceptJoinRequest(MemberGroupDTO dto) {
		service.addMember(dto.getGroupId());
		return service.acceptJoinRequest(dto) > 0 ? "요청 승인 완료" : "요청 승인 실패";
	}
	
	// 그룹 수정하기
	@PostMapping("/group/modifyGroup")
	public String modifyGroup(GroupDTO dto,
													@RequestParam("uploadFile") MultipartFile uploadFile,
													HttpServletRequest req) throws IOException {
		
		System.out.println("modify" + dto.toString());
		
		String path = req.getServletContext().getRealPath("/upload/group");
		
		String fileName = uploadFile.getOriginalFilename();
		String newFileName = FileUtil.getNewFileName(fileName);
		dto.setImage(newFileName);
		
		// DB에 파일 경로 저장
		String filePath = "../upload/group/" + newFileName;
		System.out.println(filePath);
		dto.setGrpImage(filePath);
		
		File file = new File(path + "/" + newFileName);
		
		FileUtils.writeByteArrayToFile(file, uploadFile.getBytes());
		
		int count = service.modifyGroup(dto);
		return count > 0 ? "그룹이 수정되었습니다." : "그룹 수정에 실패하였습니다.";
	}
	
	// 그룹 탈퇴하기
	@PostMapping("/group/leaveGroup")
	public String leaveGroup(MemberGroupDTO dto) {
		service.removeMember(dto.getGroupId());
		return service.leaveGroup(dto) > 0 ? "그룹 탈퇴 성공" : "그룹 탈퇴 실패";
	}
	
	
	// 그룹 삭제하기
	@GetMapping("/group/deleteGroup")
	public String deleteGroup(int grpNo) {
		int count = service.deleteGroup(grpNo);
		return count > 0 ? "그룹이 삭제되었습니다." : "그룹 삭제에 실패하였습니다.";
	}
	
	// 특정 그룹 피드 작성
	@PostMapping("/group/createFeed")
	public String createFeed(GroupFeedDTO dto) {
		System.out.println(dto);
		return service.createFeed(dto) > 0 ? "피드 작성 완료" : "피드 작성 실패";
	}
	
	// 피드에서 이미지 업로드
	@PostMapping("/group/imageUpload")
	public String imageUpload(@RequestParam("upload")MultipartFile fileLoad,
													HttpServletRequest req) throws IOException {
		
		String path = req.getServletContext().getRealPath("/upload/group");
		
		String fileName = fileLoad.getOriginalFilename();
		String newFileName = FileUtil.getNewFileName(fileName);
		
		// DB에 파일 경로 저장
		String filePath = "../upload/group/" + newFileName;
		System.out.println(filePath);
		
		File file = new File(path + "/" + newFileName);
		
		FileUtils.writeByteArrayToFile(file, fileLoad.getBytes());
		
		return filePath;
	}
	
	// 특정 피드 정보 불러오기
	@GetMapping("/group/loadPost")
	public Map<String, Object> loadPost(int grpFeedNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("loadPost", service.loadPost(grpFeedNo));
		return map; 
	}
	// 피드 수정
	@PostMapping("/group/feedModify")
	public String feedModify(GroupFeedDTO dto) {
		System.out.println(dto);
		return service.feedModify(dto) > 0 ? "피드가 수정되었습니다." : "피드 수정 실패";
	}
	
	// 피드 삭제
	@GetMapping("/group/feedDelete")
	public String feedDelete(int grpFeedNo) {
		return service.feedDelete(grpFeedNo) > 0 ? "피드가 삭제되었습니다." : "피드 삭제 실패";
	}
	
	// 특정 피드 좋아요 처리
	@PostMapping("/group/groupFeedLike")
	public String groupFeedLike(GroupFeedLikeDTO dto) {
		// 기존에 좋아요 한 적 있는지 조사
		int count = service.hasLikedGroupFeed(dto);
		if(count != 0) {
			service.groupFeedUnLike(dto);
			return "좋아요가 취소되었습니다.";
		} else {
			service.groupFeedLike(dto);
			return "좋아요가 반영되었습니다.";
		}
	}
	
	// 댓글 리스트 가져오기
	@GetMapping("/group/getCommentList")
	public Map<String,Object> getCommentList(int grpFeedNo) {
		Map<String,Object> map = new HashMap<>();
		map.put("cmtCount", service.countComment(grpFeedNo));
		map.put("cmtList", service.getCommentList(grpFeedNo));
		return map;
	}
	
	// 댓글 작성하기
	@PostMapping("/group/writeGrpFeedCmt")
	public String writeGrpFeedCmt(GroupFeedCommentDTO dto) {
		return service.writeGrpFeedCmt(dto) > 0 ? "댓글 작성이 완료되었습니다." : "댓글 등록 실패";
	}
	
	// 댓글 수정하기
	@PostMapping("/group/cmtModify")
	public String cmtModify(GroupFeedCommentDTO dto) {
		return service.cmtModify(dto) > 0 ? "댓글이 수정되었습니다." : "댓글 수정 실패";
	}
	
	
	// 댓글 삭제하기
	@GetMapping("/group/cmtDelete")
	public String cmtDelete(int grpCmtNo) {
		return service.cmtDelete(grpCmtNo) > 0 ? "댓글이 삭제되었습니다." : "댓글 삭제 실패";
	}
	
	// 댓글 내용 가져오기
	@GetMapping("/group/getCmtContent")
	public GroupFeedCommentDTO getCmtContent(int grpCmtNo) {
		return service.getCmtContent(grpCmtNo);
	}
	
	// 돌봄 그룹 피드 리스트
	@GetMapping("/group/getCareGroupAllFeed")
	public Map<String, Object> getCareGroupAllFeed(int grpNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("careGroupFeedList", service.getCareGroupAllFeed(grpNo));
		System.out.println(map.toString());
		return map;
	}
	
	// 돌봄 그룹 특정 피드 정보
	@GetMapping("/group/loadCarePost")
	public CareGroupFeedDTO loadCarePost(int careGrpFeedNo) {
		return service.loadCarePost(careGrpFeedNo);
	}
	
	// 돌봄 그룹 피드 작성 처리
	@PostMapping("/group/createCareFeed")
	public String createCareFeed(CareGroupFeedDTO dto) {
		System.out.println(dto.toString());
		return service.createCareFeed(dto) > 0 ? "피드 작성 완료" : "피드 작성 실패";
	}
	
	// 돌봄 그룹 피드 수정 처리
	@PostMapping("/group/modifyCareFeed")
	public String modifyCareFeed(CareGroupFeedDTO dto) {
		System.out.println(dto.toString());
		return service.modifyCareFeed(dto) > 0 ? "피드 수정 완료" : "피드 수정 실패";
	}
	
	// 돌봄 그룹 피드 삭제 처리
	@GetMapping("/group/deleteCareFeed")
	public String deleteCareFeed(int careGrpFeedNo) {
		System.out.println(careGrpFeedNo);
		return service.deleteCareFeed(careGrpFeedNo) > 0 ? "피드 삭제 완료" : "피드 삭제 실패";
	}
	
	
}
