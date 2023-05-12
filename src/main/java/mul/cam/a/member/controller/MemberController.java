package mul.cam.a.member.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import mul.cam.a.member.dto.AuthenticationDto;
import mul.cam.a.member.dto.MemberDto;
import mul.cam.a.member.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	MemberService service;
	
	@PostMapping(value= "/idCheck")
	public String idCheck(String id) {
		return service.idCheck(id);
	}
	
	@PostMapping(value="/emailCheck")
	public String emailCheck(String email) {
		return service.emailCheck(email);
	}
	
	@PostMapping(value = "/nicknameCheck")
	public String nicknameCheck(String nickname) {
		return service.nicknameCheck(nickname);
	}
	
	@PostMapping(value="/get/nickname")
	public String getNickname(String id) {
		System.out.println("get nickname >> " + new Date());
		return service.getNickname(id);
	}
	
	@PostMapping(value="/login")
	public HashMap<String, Object> login(String id, String password) {
		System.out.println("login controller >> " + new Date());
		System.out.println("login : "+ new Date());
		MemberDto member = new MemberDto(id, password);
		
		HashMap<String, Object> loginResult = service.login(member);
		System.out.println(loginResult.get("state"));
		System.out.println(loginResult.get("USER_ID"));
		System.out.println(loginResult.get("USER_NICKNAME"));
		return loginResult;
	}
	
	@PostMapping(value="/register")
	public String registerMember(String id, String password, String email, String nick, String number, String birth, int gender, int petHave) {
		MemberDto member = new MemberDto(id, password, email, nick, number, birth, gender, petHave);
		boolean isRegister = service.addMember(member);
		if (!isRegister) {
			return "REGISTER_NO";
		}
		return "REGISTER_OK";
	}
	
	@PostMapping(value="/findAccount/findID")
	public String findId(String email, String phone) {
		System.out.println("findId " + new Date());
		
		HashMap<String, Object> emailAndPhone = new HashMap<String, Object>();
		emailAndPhone.put("email",email);
		emailAndPhone.put("phone", phone);
		
		String userId = service.findId(emailAndPhone);
		System.out.println("USER ID >> " + userId);
		if (userId == null || userId.equals("")) {
			return "NOT_EXIST";
		}
		return userId;
	}
	
	@PostMapping(value="/findAccount/reset-password")
	public String resetPassword(String id, String email, String newPassword) {
		MemberDto member = new MemberDto(id,  newPassword, email, null, null, null, 0, 0);
		boolean isResetPassword = service.resetPassword(member);
		// "PASSWORD_RESET_OK" : "PASSWORD_RESET_NO"
		if (!isResetPassword) {
			return "PASSWORD_RESET_NO";
		}
		
		return "PASSWORD_RESET_OK";
	}
	
	// 인가code 를 redirect url 인 /kakaoAuth 에서 받는다.
	// get 을 통해 auth code 를 받을 수 있다.
	// kakao api 공식문서
	// 외부 url 로 이동하면서 데이터 전송
	@GetMapping(value="/kakaoAuth")
	public ModelAndView kakaoLogin(@RequestParam(value="code")String authCode) throws Throwable {
		ModelAndView mv = new ModelAndView();
		String userId ="";
		// 접근코드 가져오기
		String ACCESS_TOKEN = service.getKakaoAccessToken(authCode);
		System.out.println("ACCESS TOKEN >> " + ACCESS_TOKEN);
		
		// 접근코드로 유저정보(카카오)가져오기
		HashMap<String, Object> kakaoInfo = service.getKakaoInfo(ACCESS_TOKEN);
		
		// 카카오로그인한 유저의 이메일 정보가져오기
		String kakaoEmail = (String)kakaoInfo.get("email");
		
		// 이미존재하는 유저인가? (EMAIL 검증)
		String result = service.emailCheck(kakaoEmail);
		
		// sns 로 처음시작하는 경우 DB에 저장 후 유저정보 가져오기 (이후 랜덤 id 부여)
		// 기존 가입자인 경우 id 가져옴;
		if (result.equals("NOT_EXIST")) kakaoInfo = service.addMemberByNaver(kakaoInfo);
		else kakaoInfo.put("id", service.findIdByEmail(kakaoEmail));
		
		// setViewName 은 view 의 이름, redirect 를 통해 외부 url 에 이동가능
		// addObject는 url params 에 포함된다.
		mv.setViewName("redirect:http://localhost:9001/market");
		mv.addObject("USER_ID", kakaoInfo.get("id"));
		mv.addObject("USER_NICKNAME", kakaoInfo.get("nickname"));
		return mv;
	}
	
	//
	@GetMapping(value="/naverAuth")
	public ModelAndView naverLogin(@RequestParam(value="code")String authCode,
			@RequestParam(value="state")String stateToken) throws Throwable {
		System.out.println("naver auth callback controller >> " + new Date() );
		ModelAndView mv = new ModelAndView();

		String ACCESS_TOKEN = service.getNaverAccessToken(authCode);
		System.out.println("ACCESS TOKEN >> " + ACCESS_TOKEN);
		
		// 접큰코드로 유저정보(네이버)가쟈오기
		HashMap<String, Object> naverInfo = service.getNaverInfo(ACCESS_TOKEN);
		
		// 네이버로그인한 유저의 이메일정보가져오기
		String naverEmail = (String)naverInfo.get("email");
		System.out.println("네이버 이메일: " + naverEmail);
		
		// 이미존재하는 유저인가? (EMAIL 검증)
		String result = service.emailCheck(naverEmail); 
		System.out.println("이메일 존재하나요?: "+ result);
		// 기존 가입자가 아닌경우 DB저장 (이후 랜덤 id 부여)
		// 기존 가입자인 경우 id 가져옴;
		
		if (result.equals("NOT_EXIST")) naverInfo = service.addMemberByNaver(naverInfo);
		else naverInfo.put("id",service.findIdByEmail(naverEmail));
		// setViewName 은 view 의 이름, redirect 를 통해 외부 url 에 이동가능
		// addObject는 url params 에 포함된다.
		mv.setViewName("redirect:http://localhost:9001/market");
		mv.addObject("USER_ID", naverInfo.get("id"));
		mv.addObject("USER_NICKNAME", naverInfo.get("nickname"));
		return mv;
	}
	
	@PostMapping(value="/findAccount/auth")
	public String sendAuthMessage(@RequestParam(value="id")String id, @RequestParam(value="email")String email) {
		System.out.println("id:" + id + " email:" + email);
		HashMap<String, Object> idAndEmail = new HashMap<>();
		idAndEmail.put("id",id);
		idAndEmail.put("email",email);
		
		// 1. 해당 ID 와 EMAIL 이 일치하는 유저정보를 확인
		String idAndEmailCheck = service.idAndEmailCheck(idAndEmail);
		System.out.println(idAndEmailCheck);
		if (idAndEmailCheck.equals("notExist")) {
			//return "id and email dont match";
		}
		
		// 2. 유저에게 보낼 AUTHKEY 생성
		String authKey = service.createRandomAuthKey();
		System.out.println("auth key >> " + authKey);
		
		// 3. AUTH 인증정보 DB 저장 (AUTO_OK / AUTO_ERROR) + 근데 이미 있다면 update
		AuthenticationDto authentication = new AuthenticationDto(id, email, authKey);
		String saveAuth = service.addEmailAuth(authentication);
		System.out.println(saveAuth);
		
		// 4. email 로 인증번호 보내기
		service.sendEmailMessage(authKey, email);
		return saveAuth;
	}
	
	@PostMapping(value="/findAccount/auth/check")
	public String checkAuthenticationKey(String id, String email, String authKey) {
		// Authkey 비교
		AuthenticationDto authentication = new AuthenticationDto(id, email, authKey);
		String isMatchAuth = service.confirmAuthKey(authentication);
		if (isMatchAuth.equals("AUTH_CONFIRM_NO")) {
			return "AUTH_CONFIRM_NO";
		}
		String isDeleteAuth = service.deleteAuthKeyAfterConfirm(authentication);
		if (isDeleteAuth.equals("AUTH_DELETE_ERROR")) {
			return "AUTH_DELETE_ERROR";
		}
		return authKey;
	}

	
}
