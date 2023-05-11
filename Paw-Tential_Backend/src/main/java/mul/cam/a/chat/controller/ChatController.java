package mul.cam.a.chat.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.chat.dto.ChatDto;
import mul.cam.a.chat.service.ChatService;


@RestController
public class ChatController {
	
	@Autowired
	ChatService service;
	
	@PostMapping(value="/chat/save")
	public void saveChat(ChatDto chatInfo) {
		System.out.println("chat save : " + new Date());
		service.saveChat(chatInfo);
	}
	
	@PostMapping(value="/chat/view")
	public void viewChat(ChatDto chatInfo) {
		System.out.println("chat view update : " + new Date());
		System.out.println(chatInfo.toString());
		service.viewChat(chatInfo);
	}
	
	@PostMapping(value="/chat/getPrevChat") 
	public List<HashMap<String, Object>> getPrevChat(String chatroomID) {
		System.out.println("get chat prev : " + new Date());
		return service.getPrevChat(chatroomID);
	}
	
	@PostMapping(value="/chat/getNotReadChatCount")
	public int getNotReadChatCount(String chatroomID, String recipient) {
		System.out.println("get not read chat count : " + new Date());
		System.out.println("chat info >> " + chatroomID + recipient);
		return service.getNotReadChatCount(chatroomID, recipient);
	}
}
