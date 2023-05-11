package mul.cam.a.chat.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.chat.dto.ChatroomDto;

@Mapper
@Repository
public interface ChatroomDao {
	String getChatroomID(HashMap<String, Object> chatParticipant);
	int createChatroom(HashMap<String, Object> chatroomInfo);
	ChatroomDto[] getChatroomList(String USER_ID);
}
