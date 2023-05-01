package mul.cam.a.pet.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import mul.cam.a.pet.dto.PetDto;
import mul.cam.a.pet.service.PetService;
import mul.cam.a.util.FileUtil;

@RestController
public class PetController {
	@Autowired
	PetService service;
	
	@PostMapping(value="/petRegister")
	public String petRegister(@RequestPart("file")MultipartFile fileUpload,
			@RequestPart("petInfo")PetDto petInfo,
			HttpServletRequest req) {
		System.out.println("fileUpload" + new Date());
		
		// 업로드한 파일 저장할 위치 설정
		String uploadPath = req.getServletContext().getRealPath("/upload/market");
		
		// 저장했을 때 파일이름. (중복을 막기 위하여 새로운 파일이름)
		String fileName = fileUpload.getOriginalFilename();
		String newFileName = FileUtil.getNewFileName(fileName);
		String filePath = uploadPath + "/" + newFileName;
		
		
		// db에 파일명 저장하기 위한 dto 삽입
		petInfo.setImg(newFileName);
		System.out.println(petInfo.toString());
		
		String isSuccess = "";
		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			os.write(fileUpload.getBytes());			
			os.close();
			isSuccess = service.petRegister(petInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return isSuccess;
	}
}
