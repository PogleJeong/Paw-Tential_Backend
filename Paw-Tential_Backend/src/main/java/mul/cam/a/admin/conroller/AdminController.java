package mul.cam.a.admin.conroller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.admin.dto.PageParam;
import mul.cam.a.admin.dto.QnADto;
import mul.cam.a.admin.dto.ReportDto;
import mul.cam.a.admin.service.AdminService;
import mul.cam.a.member.dto.MemberDto;

@RestController
public class AdminController {
	
	@Autowired
	AdminService service;
	
	// 유저 정보
	@GetMapping(value = "userInfo")
	public MemberDto userInfo(String id) {
		System.out.println("AdminController userInfo " + new Date());
		System.out.println(service.userInfo(id));
		return service.userInfo(id);
		

	}
	
	// 회원 목록
	@GetMapping(value = "userList")
		public Map<String, Object> userList(PageParam param){
			System.out.println("회원 관리 진입 " + new Date());
			
			int pn = param.getPageNumber();  // 0 1 2 3 4
			int start = 1 + (pn * 10);	// 1  11
			int end = (pn + 1) * 10;	// 10 20 
			
			param.setStart(start);
			param.setEnd(end);
			
			List<MemberDto> list = service.userList(param);
			int len = service.getAllUser(param);
			
			
			Map<String, Object> map = new HashMap<>();
			map.put("list", list);
			map.put("cnt", len);
			

			return map;		
	}
	
	// 회원 삭제
	@GetMapping(value = "userDel")
	public String userDel(String id) {
		boolean b = service.userDel(id);
		
		if(b == false) {
			return "NO";
			
		} 
		return "YES";
	}
	
	// 신고 목록
		@GetMapping(value = "reportList")
			public Map<String, Object> reportList(PageParam param){
				System.out.println("신고 관리 진입 " + new Date());
				
				int pn = param.getPageNumber();  // 0 1 2 3 4
				int start = 1 + (pn * 10);	// 1  11
				int end = (pn + 1) * 10;	// 10 20 
				
				param.setStart(start);
				param.setEnd(end);
				
				List<ReportDto> list = service.reportList(param);
				int len = service.getAllReport(param);
				
				
				Map<String, Object> map = new HashMap<>();
				map.put("list", list);
				map.put("cnt", len);
				

				return map;
		}
		
		// 문의 목록
		@GetMapping(value = "QnAList")
			public Map<String, Object> QnAList(PageParam param){
				System.out.println("문의 관리 진입 " + new Date());
				
				int pn = param.getPageNumber();  // 0 1 2 3 4
				int start = 1 + (pn * 10);	// 1  11
				int end = (pn + 1) * 10;	// 10 20 
				
				param.setStart(start);
				param.setEnd(end);
				
				List<QnADto> list = service.QnAList(param);
				int len = service.getAllQnA(param);
				
				
				Map<String, Object> map = new HashMap<>();
				map.put("list", list);
				map.put("cnt", len);
				

				return map;
		}
	
		@PostMapping(value = "answer")
		public String answer(int seq) {
			System.out.println("문의 답변 " + new Date());
			
			boolean b = service.answer(seq);
			if(b == false) {
				return "NO";
			}
			return "YES";
		}
		

}
