package mul.cam.a.myfeed.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import mul.cam.a.admin.dto.PageParam;
import mul.cam.a.feed.dto.FeedDto;
import mul.cam.a.group.util.FileUtil;
import mul.cam.a.member.dto.MemberDto;
import mul.cam.a.myfeed.dto.FollowDto;
import mul.cam.a.myfeed.service.MyfeedService;

@RestController // @Controller에 @ResponseBody가 추가된 것 Json 형태로 객체 데이터를 반환
public class MyfeedController {
	@Autowired
	MyfeedService service;

	
	//모든피드 불러오기
	@GetMapping(value = "Myfeed")
	public List<FeedDto> Myfeed(String id) {
		System.out.println("myfeed 진입 " + new Date());
		List<FeedDto> myfeed = service.Myfeed(id);
		return myfeed;
	}
	
	@GetMapping(value = "getFollower")
	public int getFollower (String id) {
		System.out.println("팔로워 총 수 " + new Date());
		
		return service.getFollower(id);
	}
	
	@GetMapping(value = "getFollowing")
	public int getFollowing (String id) {
		System.out.println("팔로잉 총 수 " + new Date());
		
		return service.getFollowing(id);
	}
	
	@PostMapping(value = "follow")
	public String follow (FollowDto dto) {
		System.out.println("팔로우 " + new Date());
		boolean b = service.follow(dto);
		
		if(b == false) {
			return "NO";
			
		} 
		return "YES";

	}
	
	@PostMapping(value = "unfollow")
	public String unfollow (FollowDto dto) {
		System.out.println("언팔로우 " + new Date());
		boolean b = service.unfollow(dto);
		
		if(b == false) {
			return "NO";
			
		} 
		return "YES";

	}
	
	
	@GetMapping(value = "followerList")
	public List<String> followerList(String id){
		System.out.println("팔로워 리스트" + new Date());
		System.out.println("id : " + id);
		
		return service.followerList(id);

	}
	
	@GetMapping(value = "followingList")
	public List<String> followingList(String id){
		System.out.println("팔로잉 리스트" + new Date());
		
		return service.followingList(id);

	}
	
	@PostMapping(value = "isFollowing")
	public String isFollowing(String follower_id, String following_id){
		System.out.println("팔로잉 체크" + new Date());
		
		boolean b = service.isFollowing(follower_id, following_id);
		
		if(b == false) {
			return "NO";
			
		} 
		return "YES";

	}
	
	@GetMapping(value = "searchMember")
	public List<MemberDto> searchMember(PageParam param){
		System.out.println("유저 리스트" + new Date());
		System.out.println("id : " + service.searchMember(param));
		List<MemberDto> list = service.searchMember(param);
		
		
		return list;

	}
	
	@PostMapping(value = "editMember")
	public String editMember(MemberDto dto, @RequestPart(required = false, value = "upload") MultipartFile uploadFile,
	        HttpServletRequest req) {
	    System.out.println("회원정보수정 체크" + new Date());
	    System.out.println(service.editMember(dto));

	    // 업로드된 파일 처리
	    if (!uploadFile.isEmpty()) {
	        try {
	            // 업로드할 디렉토리 경로 설정
	            String uploadPath = req.getServletContext().getRealPath("/upload/myfeed");

	            // 업로드된 파일의 원본 파일명과 새로운 파일명 생성
	            String originalFilename = uploadFile.getOriginalFilename();
	            String newFileName = FileUtil.getNewFileName(originalFilename);

	            // 파일 경로 설정
	            String filePath = "../upload/myfeed/" + newFileName;
	            System.out.println(filePath);
	            dto.setProfile(filePath);

	            // 파일 저장
	            File file = new File(uploadPath, newFileName);
	            FileUtils.writeByteArrayToFile(file, uploadFile.getBytes());

	        } catch (IOException e) {
	            e.printStackTrace();

	            // 파일 업로드 실패 시 예외 처리
	            return "NO";
	        }
	    }

	    boolean b = service.editMember(dto);

	    if (!b) {
	        return "NO";
	    }

	    return "YES";
	}
	
	
	
}
