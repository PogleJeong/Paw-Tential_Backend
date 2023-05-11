package mul.cam.a.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.handler.annotation.MessageMapping;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import lombok.RequiredArgsConstructor;
import mul.cam.a.chat.dto.ChatDto;

@CrossOrigin(origins = "http://localhost:9001")
@Controller
@RequiredArgsConstructor // sts 에서 자동인식이 안되므로 수동설치 필요
 // final 이나 @NotNull 이 붙은 필드의 생성자를 자동생성
public class StompChatController {
	
	private final SimpMessagingTemplate template;
	
	/*
		config 에서 설정한 applicationDestinationPrefixes 와 @MessageMapping 경로가 병합됨.
		~Prefixes : /pub
		@MessageMapping : /chat/enter
		병합된 경로 : /pub/chat/enter
		
		SimpleMessagingTemplate.convertAndSend("메세지보낼경로", 보낼데이터);
	*/
	@MessageMapping(value="/chat/enter")
	public void enter(ChatDto chatInfo) {
		chatInfo.setMessage(chatInfo.getSender() + "님이 채팅방에 참여하였습니다.");
		template.convertAndSend("/sub/chat/room/"+chatInfo.getChatroomID(), chatInfo);
	}
	
	@MessageMapping(value="/chat/send")
	public void message(ChatDto chatInfo) {
		// stomp.send(path, body, header) : body 부분에 chatInfo 들어가야함.
		
		System.out.println(chatInfo.toString());
		template.convertAndSend("/sub/chat/room/"+chatInfo.getChatroomID(), chatInfo);
	}
}
