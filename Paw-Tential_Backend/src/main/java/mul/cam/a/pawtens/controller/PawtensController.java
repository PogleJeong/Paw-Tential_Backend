package mul.cam.a.pawtens.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import mul.cam.a.feed.dto.FeedDto;
import mul.cam.a.feed.dto.FeedParam;
import mul.cam.a.market.dto.MarketDto;
import mul.cam.a.pawtens.dto.PawtensDto;
import mul.cam.a.pawtens.service.PawtensService;
import mul.cam.a.util.FileUtil;

@RestController
public class PawtensController {
	
	@Autowired
	PawtensService service;
	
	@GetMapping(value = "/pawtens")
	public Map<String, Object> pawtens(FeedParam param){
		System.out.println("PawtensController pawtens()" + new Date());
		
		// 포텐스의 시작과 끝
		int pn = param.getPageNumber();	// 0 1 2 3 ...
		int start = 1 + (pn * 12);		// 1 6 11 16 ...
		int end = (pn + 1) * 12;		// 5 10 15 20 ...
		
		param.setStart(start);
		param.setEnd(end);
		
		List<FeedDto> list = service.pawtensList(param);
		
		// 포텐스의 총 개수
		int len = service.getAllPawtens(param);
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);  // 포텐스 리스트
		map.put("cnt", len);	// 포텐스 총 개수

		return map;
	}
	
	@PostMapping(value = "/pawtens/write")
	public String pawtensWrite(@RequestPart(value="file") MultipartFile thumbnail,
								PawtensDto dto,
								HttpServletRequest req) {
		System.out.println("PawtensController pawtensWrite()" + new Date());
		
		// 업로드한 파일 저장할 위치 설정
		String uploadPath = req.getServletContext().getRealPath("/upload/pawtens");
		
		// 저장했을 때 파일이름. (중복을 막기 위하여 새로운 파일이름)
		String fileName = thumbnail.getOriginalFilename();
		String newFileName = FileUtil.getNewFileName(fileName);
		String filePath = uploadPath + "/" + newFileName;
		
		
		// db에 파일명 저장하기 위한 dto 삽입
		dto.setFilename(newFileName);
		dto.setRealpathfile(fileName);
		System.out.println(dto.toString());
		
		boolean result = false;
		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			os.write(thumbnail.getBytes());			
			os.close();
			result = service.pawtensWrite(dto);
		} catch (Exception e) {
			e.printStackTrace();
			return "FILE_UPLOAD_FAIL";
		}
		
		if (!result) {
			return "포텐스 작성 실패";
		}
		return "포텐스 작성 완료";
	}

}
