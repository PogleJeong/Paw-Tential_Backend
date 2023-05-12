package mul.cam.a.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

import mul.cam.a.chat.dto.ChatroomDto;
import mul.cam.a.chat.service.ChatroomService;

@RestController
public class ChatroomController {
	
	@Autowired
	ChatroomService service;
	
	/* 채팅방만들기 */
	@PostMapping(value="/createChat")
	public ModelAndView createChat(
			@RequestParam(value="sender")String sender, 
			@RequestParam(value="recipient")String recipient) {
		System.out.println("create chat controller : " + new Date());
		ModelAndView mv = new ModelAndView();
		
		// 이전에 판매자와 채팅내역이 있는지 확인
		// 존재한다면 해당 채팅방의 ID를 그게 아니면 새로운 chatroomID 를 부여(DB)저장
		String chatroomID = service.getChatroomID(sender, recipient);
		
		mv.setViewName("redirect:http://localhost:9001/chat/" + chatroomID);
		mv.addObject("chatroomID", chatroomID);
		mv.addObject("sender", sender);
		mv.addObject("recipient", recipient);
		return mv;
	}
	
	/* 채팅방리스트 출력 */
	@GetMapping(value="/chat/home")
	public ChatroomDto[] getChatroomList(String USER_ID) {
		System.out.println("get chatroom list controller : " + new Date());
		System.out.println("USER_ID >> " + USER_ID);
		ChatroomDto[] chatroomList = service.getChatroomList(USER_ID);
		if (chatroomList == null) {
			System.out.println("null 값");
		}
		return chatroomList;
	}
}
