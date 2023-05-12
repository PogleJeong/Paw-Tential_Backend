package mul.cam.a.market.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.mail.Multipart;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import mul.cam.a.market.dto.MarketDto;
import mul.cam.a.market.dto.MarketReportDto;
import mul.cam.a.market.service.MarketService;
import mul.cam.a.util.FileUtil;

@RestController
public class MarketController {
	
	@Autowired
	MarketService service;
	
	@PostMapping(value="/market")
	public HashMap<String, Object> marketHome(HttpServletRequest req,
			 int pages) {
		System.out.println("market home Controller >> " + new Date());
		System.out.println("pages >> " + pages);
		
		MarketDto[] marketInfoList = service.printAllMarketSearch(pages);
		List<byte[]> imageList = new ArrayList<byte[]>();
		
		// 마켓 리스트 가져오고 파일데이터를 처리
		// Map (마켓리스트 , 파일이미지)
		for (MarketDto marketInfo : marketInfoList) {
			System.out.println(marketInfo.toString());
			try {
				// 업로드파일위치
				String uploadPath = req.getServletContext().getRealPath("/upload/market/"+marketInfo.getFile());
				InputStream imageStream = new FileInputStream(uploadPath);
				byte[] imageByte = IOUtils.toByteArray(imageStream);
				
				// 
				imageList.add(imageByte);
			}catch (Exception e) {
				System.out.println("파일불러오기 오류");
				return null;
			}
		}
		
		HashMap<String, Object> marketInfoListAndImage = new HashMap<>();
		marketInfoListAndImage.put("marketInfoList", marketInfoList);
		marketInfoListAndImage.put("imageList", imageList);
		
		System.out.println(marketInfoListAndImage.get("marketInfoList"));
		System.out.println(marketInfoListAndImage.get("imageList"));
		
		return marketInfoListAndImage;
	}
	
	@PostMapping(value="/searchMarket")
	public HashMap<String, Object> searchMarket(String selectedOption, String searchWord, int pages,
			HttpServletRequest req) {
		System.out.println("market search Controller >> " + new Date());
		System.out.println("selectedOption >> " + selectedOption);
		System.out.println("searchword >> " + searchWord);
		// selectedOption : 전체/제목/내용...
		
		MarketDto[] marketInfoList = service.searchMarket(selectedOption, searchWord, pages);
		List<byte[]> imageList = new ArrayList<byte[]>();
		
		// 마켓 리스트 가져오고 파일데이터를 처리
		// Map (마켓리스트 , 파일이미지)
		for (MarketDto marketInfo : marketInfoList) {
			System.out.println(marketInfo.toString());
			try {
				// 업로드파일위치
				String uploadPath = req.getServletContext().getRealPath("/upload/market/"+marketInfo.getFile());
				InputStream imageStream = new FileInputStream(uploadPath);
				byte[] imageByte = IOUtils.toByteArray(imageStream);
				
				// 
				imageList.add(imageByte);
			}catch (Exception e) {
				System.out.println("파일불러오기 오류");
				return null;
			}
		}
		
		HashMap<String, Object> marketInfoListAndImage = new HashMap<>();
		marketInfoListAndImage.put("marketInfoList", marketInfoList);
		marketInfoListAndImage.put("imageList", imageList);
		
		System.out.println(marketInfoListAndImage.get("marketInfoList"));
		System.out.println(marketInfoListAndImage.get("imageList"));
		
		return marketInfoListAndImage;
	}
	@PostMapping(value="/market/write")
	public String writeMarket(@RequestPart(value="file") MultipartFile thumbnail,
			@RequestPart(value="marketInfo") MarketDto writeMarketInfo,
			HttpServletRequest req) {
		System.out.println("write market >> " + new Date());
		System.out.println("file : " + thumbnail);
		System.out.println("market info : " + writeMarketInfo);
		// 업로드한 파일 저장할 위치 설정
		String uploadPath = req.getServletContext().getRealPath("/upload/market");
		
		// 저장했을 때 파일이름. (중복을 막기 위하여 새로운 파일이름)
		String fileName = thumbnail.getOriginalFilename();
		String newFileName = FileUtil.getNewFileName(fileName);
		String filePath = uploadPath + "/" + newFileName;
		
		
		// db에 파일명 저장하기 위한 dto 삽입
		writeMarketInfo.setFile(newFileName);
		System.out.println(writeMarketInfo.toString());
		
		boolean result = false;
		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			os.write(thumbnail.getBytes());			
			os.close();
			result = service.writeMarket(writeMarketInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return "FILE_UPLOAD_FILE";
		}
		
		if (!result) {
			return "MARKET_WRITE_NO";
		}
		return "MARKET_WRITE_OK";
	}
	
	@PostMapping(value="/market/update")
	public String updateMarket(@RequestPart(value="file")MultipartFile thumbnail
			,@RequestPart(value="marketInfo") MarketDto updateMarketInfo
			,HttpServletRequest req) {
		System.out.println("update market >> " + new Date());
		System.out.println(updateMarketInfo.toString());	
		
		// 업로드한 파일 저장할 위치 설정
		String uploadPath = req.getServletContext().getRealPath("/upload/market");
		
		// 저장했을 때 파일이름. (중복을 막기 위하여 새로운 파일이름)
		String fileName = thumbnail.getOriginalFilename();
		String newFileName = FileUtil.getNewFileName(fileName);
		String filePath = uploadPath + "/" + newFileName;
		
		
		// db에 파일명 저장하기 위한 dto 삽입
		updateMarketInfo.setFile(newFileName);
		System.out.println(updateMarketInfo.toString());
		
		boolean result = false;
		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			os.write(thumbnail.getBytes());			
			os.close();
			result = service.updateMarket(updateMarketInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return "FILE_UPLOAD_FILE";
		}
		
		
		if (!result) {
			return "MARKET_UPDATE_NO";
		}
		return "MARKET_UPDATE_YES";
	}
	
	@PostMapping(value="/market/delete")
	public String deleteMarket(String id, int posting) {
		System.out.println("delete market >> " + new Date());
		System.out.println("id = " + id + " | posting = " + posting );
		
		boolean result = service.deleteMarket(id, posting);
		
		if (!result) {
			return "MARKET_DELETE_NO";
		}
		return "MARKET_DELETE_OK";
	}
	
	@PostMapping(value="/market/report")
	public String reportMarket(MarketReportDto reportInfo) {
		System.out.println("market report controller >> " + new Date());
		return service.reportMarket(reportInfo);
	}
	
	// 이상하게 2번호출됨.
	@PostMapping(value="/market/view/add") 
	public void viewAddMarket(String id, int posting){
		System.out.println("view add controller >> " + new Date());
		service.viewAddMarket(id, posting);
		System.out.println("posting >> " + posting);
		return;
	}
	
	@PostMapping(value="market/view/print")
	public int viewPrintMarket(int posting) {
		System.out.println("view print controller >> " + new Date());
		System.out.println("posting >> " + posting);
		
		int viewCount = service.viewPrint(posting);
		System.out.println("view count : " + viewCount);
		
		return viewCount;
	}
	
	@PostMapping(value="/market/upload")
	public String marketFileUplaod(@RequestPart(value="upload")MultipartFile fileUpload,
			HttpServletRequest req) {
	
		return "succces";
	}
	
	// 해당게시물의 좋아요개수
	// 유저가 좋아요 누른적 있는지
	@PostMapping(value="/market/like")
	public HashMap<String, Object> marketHistoryOfLike(String loginUser, int posting) {
		System.out.println("MarketHistoryOfLike Controller >> " + new Date());
		HashMap<String, Object> sendInfo = new HashMap<>();
		sendInfo.put("id", loginUser);
		sendInfo.put("posting", posting);
		HashMap<String, Object> histroyOfLike = service.marketHistoryOfLike(sendInfo);
		if (histroyOfLike == null) {
			return null; 
		}
		return histroyOfLike;
	}
	
	// 좋아요 클릭시 등록 및 해제
	@PostMapping(value="/market/like/click")
	public HashMap<String, Object> marketChangeLike(String loginUser, int posting, boolean like) {
		System.out.println("marketChangeLike Controller >> " + new Date());
		HashMap<String, Object> sendInfo = new HashMap<>();
		HashMap<String, Object> resultInfo = new HashMap<>();
		
		System.out.println("id: " + loginUser + "| posting: " + posting + "| like history: " + like);
		sendInfo.put("id", loginUser);
		sendInfo.put("posting", posting);
		sendInfo.put("likeHistory", like);	
		
		// 좋아요 정보변환
		String message = service.marketChangeLike(sendInfo);
		if (message.equals("LIKE_ADD_NO") || message.equals("LIKE_REMOVE_NO")){
			return null;
		}
		resultInfo.put("message", message);
		
		// 좋아요 개수반환
		int likeNumber = service.marketNumberofLike(posting);
		resultInfo.put("likeNumber", likeNumber);
		
		return resultInfo;
	}
}
