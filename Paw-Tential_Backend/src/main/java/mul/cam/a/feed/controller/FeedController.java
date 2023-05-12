package mul.cam.a.feed.controller;

import mul.cam.a.feed.dto.FeedDto;
import mul.cam.a.feed.service.FeedService;
import mul.cam.a.group.util.FileUtil;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // @Controller에 @ResponseBody가 추가된 것 Json 형태로 객체 데이터를 반환
public class FeedController {

	@Autowired
	FeedService service;

	//모든피드 불러오기
	@GetMapping("/mainFeed")
	public List<Map<String, Object>> mainFeed() {
		System.out.println("mainFeed baseLayout " + new Date());
		List<Map<String, Object>> feed = service.feed();
		return feed;
	}

	// 로그인후,팔로우한 피드까지 불러오기
	@GetMapping("/{id}/mainFeed")
	public List<FeedDto> getFollowToUsersFeed(@PathVariable String id) {
		System.out.println("getFollowToUsersFeed baseLayout" + new Date());
		return service.getFollowToUsersFeed(id);

	}

	//피드 작성
	@PostMapping("/feedWrite")
	public String feedWrite(FeedDto dto) {
		System.out.println("FeedController feedWrite() " + new Date());

		return service.feedWrite(dto);
	}

	// 피드에서 이미지 업로드
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

	// 특정 피드 정보 불러오기
	@GetMapping("/getFeedInfo")
	public Map<String, Object> getFeedInfo(int seq) {
		System.out.println("FeedController getFeedInfo() " + new Date());

		Map<String, Object> map = new HashMap<>();
		map.put("loadPost", service.getFeedInfo(seq));

		return map;
	}

	// 피드 수정
	@PostMapping("/feedUpdate")
	public String feedModify(FeedDto dto) {
		System.out.println("FeedController feedModify() " + new Date());

		return service.feedUpdate(dto);
	}

	// 피드 삭제
	@GetMapping("/feedDelete")
	public String feedDelete(int seq) {
		System.out.println("FeedController feedDelete() " + new Date());

		return service.feedDelete(seq);
	}

}
