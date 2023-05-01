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
	
	@PostMapping(value = "/nicknameCheck")
	public String nicknameCheck(String nickname) {
		return service.nicknameCheck(nickname);
	}
	
	@PostMapping(value="/login")
	public HashMap<String, Object> login(String id, String password) {
		System.out.println("login controller >> " + new Date());
		System.out.println("login : "+ new Date());
		MemberDto member = new MemberDto(id, password);
		
		HashMap<String, Object> loginResult = service.login(member);
		System.out.println(loginResult.get("state"));
		System.out.println(loginResult.get("userId"));
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
		// 접근코드 가져오기
		String ACCESS_TOKEN = service.getAccessToken(authCode);
		System.out.println("ACCESS TOKEN >> " + ACCESS_TOKEN);
		
		// 접근코드로 유저정보(카카오)가져오기
		HashMap<String, Object> userInfo = service.getUserInfo(ACCESS_TOKEN);
		
		// setViewName 은 view 의 이름, redirect 를 통해 외부 url 에 이동가능
		// addObject는 url params 에 포함된다.
		mv.setViewName("redirect:http://localhost:9001/login/kakaoAuth");
		mv.addObject("userInfo", userInfo.get("nickname"));
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
