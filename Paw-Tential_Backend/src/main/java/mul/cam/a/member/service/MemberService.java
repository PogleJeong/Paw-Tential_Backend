package mul.cam.a.member.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import mul.cam.a.member.dao.MemberDao;
import mul.cam.a.member.dto.AuthenticationDto;
import mul.cam.a.member.dto.MemberDto;

@Service
@Transactional
public class MemberService {
	@Autowired
	MemberDao dao;
	
	public String idCheck(String id) {
		return dao.idCheck(id) > 0 ? "exist" : "notExist";
	}
	public String nicknameCheck(String nickname) {
		return dao.nicknameCheck(nickname) > 0 ? "exist" : "notExist";
	}
	
	public String idAndEmailCheck(HashMap<String, Object> idAndEmail) {
		return dao.idAndEmailCheck(idAndEmail) != null ? "exist": "notExist" ;
	}
	
	public HashMap<String, Object> login(MemberDto member) {
		System.out.println("login service >> " + new Date());
		HashMap<String, Object> loginResult = new HashMap<>();
		
		// 해당 ID가 존재하는지
		MemberDto userInfo = dao.login(member); // id 를 이용해 user 정보가져옴
		if (userInfo == null) {
			loginResult.put("state", "LOGIN_NOT_FOUND_ID");
			loginResult.put("userInfo", null);
			return loginResult;
		}
	
		// DB에서 해싱비밀번호를 꺼내고 비교해야함 (같은 비밀번호를 해싱하여도 다른값이 나오기 때문)
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		boolean matchPassword = passwordEncoder.matches(member.getPwd(), userInfo.getPwd());
		
		if (matchPassword == false) {
			loginResult.put("state", "LOGIN_NOT_MATCH_PASSWORD");
			loginResult.put("userInfo", null);
			return loginResult;
		}
		loginResult.put("state", "LOGIN_SUCCESS");
		loginResult.put("userId", userInfo.getId());
		
		return loginResult;
	}
	
	public boolean addMember(MemberDto member) {
		// 비밀번호 복호화 Bcrypt
		System.out.println("회원가입 >> " + new Date());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println("변환전 >> " + member.getPwd());
		String encordedPassword = passwordEncoder.encode(member.getPwd());
		member.setPwd(encordedPassword);
		System.out.println("변환후 >> " + member.getPwd());
		return dao.addMember(member) > 0 ? true : false;
	}
	
	public String findId(HashMap<String, Object> emailAndPhone) {
		System.out.println("findId : service " + new Date());
		System.out.println(emailAndPhone.get("email"));
		System.out.println(emailAndPhone.get("phone"));
		
		return dao.findId(emailAndPhone);
	}
	
	public boolean resetPassword(MemberDto member) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encordedPassword = passwordEncoder.encode(member.getPwd());
		member.setPwd(encordedPassword);
		return dao.resetPassword(member) > 0 ? true : false;
	}
	
	// 공식문서 참조 (액세스 토큰) - REST API 토큰받기 부분 
	// 공식문서 : Auth code 만으로는 로그인을 할 수 없습니다. 토큰받기까지 마쳐야 로그인을 정상적으로 할 수 있습니다.
	public String getAccessToken(String AuthCode) {
		String CLIENT_ID = "83e8bb6f53c1f3fcc8901a9678d3eaa3";
		String REDIRECT_URI = "http://localhost:3000/kakaoAuth";
		
		String ACCESS_TOKEN = "";
		String REFRESH_TOKEN = "";
		String REQUEST_URL = "https://kauth.kakao.com/oauth/token";
		
		// 토큰요청 보내기
		// HttpURLConnection 사용법 참고
		try {
			// URL 객체생성 및 연결
			URL url = new URL(REQUEST_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 설정
			conn.setRequestMethod("POST"); // Token: POST request
			conn.setDoOutput(true); // post 요청
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			// request parameter 추가
			sb.append("grant_type=authorization_code");
			sb.append("&client_id="+ CLIENT_ID);
			sb.append("&redirect_uri="+ REDIRECT_URI);
			sb.append("&code="+ AuthCode);
			
			// flush() : 버퍼(임시메모리)에 있는 데이터를 모두 처리 : write() 함수 후에 쓰는것이 좋음.
			bw.write(sb.toString());
			bw.flush(); 
			
			// url 보내고 reponse 를 받아옴
			int responseStatusCode = conn.getResponseCode();
			System.out.println("status: " + responseStatusCode);
			
			/** 성공시 (200)
			 	HTTP/1.1 200 OK
				Content-Type: application/json;charset=UTF-8
				{
				    "token_type":"bearer",
				    "access_token":"${ACCESS_TOKEN}",
				    "expires_in":43199,
				    "refresh_token":"${REFRESH_TOKEN}",
				    "refresh_token_expires_in":25184000,
				    "scope":"account_email profile"
				}
			 */
			
			// Response 가져오기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			// 개행을 기준으로 가져오므로 
			String responseOneLine = "";
			String responseBody = "";
			while ((responseOneLine = br.readLine()) != null) {
				responseBody += responseOneLine;
			}
			System.out.println("response body: " + responseBody);
			
			Gson gson = new Gson();
			// Json 문자열 -> Map
	        Map<String, Object> responseBodyMap = gson.fromJson(responseBody, Map.class);
	 
	        // Map 출력
	        for (Map.Entry<String, Object> entry : responseBodyMap.entrySet()) {
	            System.out.println(entry.getKey() + "=" + entry.getValue());
	        }
	        ACCESS_TOKEN = (String)responseBodyMap.get("access_token");
	        REFRESH_TOKEN = (String)responseBodyMap.get("refresh_token");
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
		return ACCESS_TOKEN;
	}
	
	// 사용자정보가져오기
	// 사용자정보가져오기 공식문서 참고
	public HashMap<String, Object> getUserInfo(String ACCESS_TOKEN) throws Throwable {
		// 유저의 정보들은 각각 존재하는 정보가 다를 수 있으므로 HasgMap으로 받음
		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		String requestURL = "https://kapi.kakao.com/v2/user/me";
		
		try {
			URL url = new URL(requestURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);
			/*
			 	GET/POST /v2/user/me HTTP/1.1
				Host: kapi.kakao.com
				Authorization: Bearer ${ACCESS_TOKEN}/KakaoAK ${APP_ADMIN_KEY}
				Content-type: application/x-www-form-urlencoded;charset=utf-8
			*/
			int responseStatusCode = conn.getResponseCode();
			System.out.println("get UserInfo status >>" + responseStatusCode);
			
			// response body 읽기
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String responseOneLine = "";
			String responseBody = "";
			while((responseOneLine = br.readLine()) != null) {
				responseBody += responseOneLine;
			}
			System.out.println("response body : get user info >> " + responseBody);
			
			// 유저정보를 Map 에 저장
			try {
				Gson gson = new Gson();
				Map<String, Object> userInfoMap = gson.fromJson(responseBody, Map.class);
				
				// 유저정보는 properties 와 kakao_account 로 나뉘어져있음
				Map<String, Object> properties = (Map<String, Object>)userInfoMap.get("properties");
				Map<String, Object> kakao_account = (Map<String, Object>)userInfoMap.get("kakao_account");
				
				// properties 에서 정보가져오기 (nickname)
				userInfo.put("nickname", properties.get("nickname"));
				//출력 : System.out.println(gson.toJson(userInfo));
				
				// 유저 properties 와 
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return userInfo;
	}
	
	public String createRandomAuthKey() {
		String authKey = "";
		int alphaOrNumber;
		for (int i=0; i<8; i++) {
			alphaOrNumber = (int)(Math.random()*3);
			
			if(alphaOrNumber==0) {
				// 알파켓코드(대문자)
				authKey += (char)(int)(Math.random()*26 + 65);
			} else if(alphaOrNumber == 1){
				// 알파벳코드(소문자)
				authKey += (char)(int)(Math.random()*26 + 97);
			}else if (alphaOrNumber == 2) {
				// 숫자코드
				authKey += (char)(int)(Math.random()*10 + 48);
			}
		}
		
		return authKey;
	}
	
	public String addEmailAuth(AuthenticationDto authentication) {
		Boolean authExist = dao.checkExistEmailAuth(authentication)>0 ? true : false;
		
		// 1. 재발급하는가 아니면 새로 발급하는가
		if (authExist) {
			return dao.updateEmailAuth(authentication) > 0 ? "AUTH_UPDATE_OK" : "AUTH_UPDATE_ERROR";
		}else {
			return dao.addEmailAuth(authentication) > 0 ? "AUTH_ADD_OK" : "AUTH_ADD_ERROR";			
		}
	}
	
	public void sendEmailMessage(String authKey, String email) {
		String recipient = email;
        String code = authKey;
 
        // 1. 발신자의 메일 계정과 비밀번호 설정
        final String user = "jes4958@naver.com";
        final String password = "19-506784qhrmq@";
 
        // 2. Property에 SMTP 서버 정보 설정
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.naver.com");
        prop.put("mail.smtp.port", 465);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
 
        // 3. SMTP 서버정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스 생성
        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
 
        // 4. Message 클래스의 객체를 사용하여 수신자와 내용, 제목의 메시지를 작성한다.
        // 5. Transport 클래스를 사용하여 작성한 메세지를 전달한다.
 
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(user));
 
            // 수신자 메일 주소
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
 
            // Subject
            message.setSubject("Paw-Tential 에서 보내는 인증메일입니다.");
 
            // Text
            String content = "<p>Paw-Tential 인증번호입니다.";
            
            content += "<p style='background-color: rgb(92.209,229); color: black; font-weight: bold; font-size: 30px;'>"
            		+ code
            		+ "</p>";
            
            content += "<p>Copyright @Paw-Tential Team, 2023, All Rights Reserved";
            		
            message.setContent(content, "text/html;charset=utf-8");
 
            Transport.send(message);    // send message
 
 
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}
	public String deleteAuthKeyAfterConfirm(AuthenticationDto authentication) {
		return dao.deleteAuthKeyAfterConfirm(authentication) > 0 ? "AUTH_DELETE_OK" : "AUTH_DELETE_ERROR";
	}
	public String confirmAuthKey(AuthenticationDto authentication) {
		return dao.confirmAuthKey(authentication) > 0 ? "AUTH_CONFIRM_OK" : "AUTH_CONFIRM_NO";
	}
}
