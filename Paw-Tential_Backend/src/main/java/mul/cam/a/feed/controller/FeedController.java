package mul.cam.a.feed.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
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
import mul.cam.a.feed.dto.FeedDto;
import mul.cam.a.feed.service.FeedService;
import mul.cam.a.group.util.FileUtil;

@RestController // @Controller에 @ResponseBody가 추가된 것 Json 형태로 객체 데이터를 반환
public class FeedController {

	@Autowired
	FeedService service;
	
	// 메인 - 모든 피드 불러오기
	@GetMapping("/home/allFeed")
	public Map<String, Object> getAllFeed(){
		Map<String, Object> map =  new HashMap<>();
		map.put("feedList", service.getAllFeed());
		return map;
	}
	
	// 메인 - 특정 피드 원본 불러오기
	@GetMapping("/home/loadPost")
	public FeedDto loadPost(int seq) {
		return service.loadPost(seq);
	}
	
	// 메인 - 피드 작성하기
	@PostMapping("/home/feedWrite")
	public String feedWrite(FeedDto dto) {
		return service.feedWrite(dto) > 0 ? "피드가 작성되었습니다." : "피드 작성에 실패하였습니다.";
	}
	
	
	// 메인 - 특정 피드 수정하기
	@PostMapping("/home/feedModify")
	public String feedModify(FeedDto dto) {
		return service.feedModify(dto) > 0 ? "피드가 수정되었습니다." : "피드 수정에 실패하였습니다.";
	}
	
	// 메인 - 피드에서 이미지 업로드
	@PostMapping("/feedImageUpload")
	public String feedImageUpload(@RequestParam("upload") MultipartFile fileLoad, HttpServletRequest req)
			throws IOException {
		System.out.println("FeedController feedImageUpload() " + new Date());

		String path = req.getServletContext().getRealPath("/upload/feed");

		String fileName = fileLoad.getOriginalFilename();
		String newFileName = FileUtil.getNewFileName(fileName);

		// DB에 파일 경로 저장
		String filePath = "../upload/feed/" + newFileName;
		System.out.println(filePath);

		File file = new File(path + "/" + newFileName);

		FileUtils.writeByteArrayToFile(file, fileLoad.getBytes());

		return filePath;
	}
	
	// 메인 - 특정 피드 삭제
	@GetMapping("/home/feedDelete")
	public String feedDelete(int seq) {
		return service.feedDelete(seq) > 0 ? "피드가 삭제되었습니다." : "피드 삭제에 실패하였습니다." ;
	}

}
