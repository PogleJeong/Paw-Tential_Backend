package mul.cam.a.chat.service;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.chat.dao.ChatroomDao;
import mul.cam.a.chat.dto.ChatroomDto;

@Service
@Transactional
public class ChatroomService {
	
	@Autowired
	ChatroomDao dao;
	
	public String getChatroomID(String sender, String recipient) {
		System.out.println("get chatroom id service : " + new Date());
		HashMap<String ,Object> chatParticipant = new HashMap<>();
		chatParticipant.put("sender", sender);
		chatParticipant.put("recipient", recipient);
		String chatroomID = dao.getChatroomID(chatParticipant);
		
		// 채팅이력이 존재하지 않은 경우 새 채팅방ID 부여.
		if (chatroomID == null || chatroomID == "") {
			chatroomID = UUID.randomUUID().toString();
			System.out.println("새 채팅방 id 부여 : " + chatroomID );
			chatParticipant.put("chat_id", chatroomID);
			
			// DB 에 채팅방정보 저장
			boolean isCreated = dao.createChatroom(chatParticipant) > 0 ? true : false;
			if (isCreated) {
				System.out.println("DB저장성공");
			}else {
				System.out.println("DB저장실패");
			}	
		}
		// 채팅이력이 있을 경우 해당 채팅방ID 반환
		return chatroomID;
	}
	
	public ChatroomDto[] getChatroomList(String USER_ID) {
		System.out.println("get chatroom list service : " + new Date());
		System.out.println("가져온 채팅방 리스트 >>");
		ChatroomDto[] chatroomList = dao.getChatroomList(USER_ID);
		for (ChatroomDto chatroom : chatroomList) {
			System.out.println(chatroom.toString());	
		}
		return chatroomList;
	}
}
