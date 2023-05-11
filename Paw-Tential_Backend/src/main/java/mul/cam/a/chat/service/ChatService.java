package mul.cam.a.chat.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.chat.dao.ChatDao;
import mul.cam.a.chat.dto.ChatDto;

@Service
@Transactional
public class ChatService {
	
	@Autowired
	ChatDao dao;
	
	public void saveChat(ChatDto chatInfo) {
		dao.saveChat(chatInfo);
	}
	
	public void viewChat(ChatDto chatInfo) {
		dao.viewChat(chatInfo);
	}
	
	public List<HashMap<String, Object>> getPrevChat(String chatroomID) {
		System.out.println("get prev chat : " + new Date());
		System.out.println("chatroom id >> " + chatroomID);
		return dao.getPrevChat(chatroomID);
	}
	
	public int getNotReadChatCount(String chatroomID, String recipient) {
		System.out.println("get not read chat count : " + new Date());
		HashMap<String, Object> chatInfo = new HashMap<>();
		chatInfo.put("chatroomID", chatroomID);
		chatInfo.put("recipient", recipient);
		return dao.getNotReadChatCount(chatInfo);
	}
}
