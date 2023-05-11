package mul.cam.a.chat.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.chat.dto.ChatDto;

@Repository
@Mapper
public interface ChatDao {
	void saveChat(ChatDto chatInfo);
	void viewChat(ChatDto chatInfo);
	List<HashMap<String, Object>> getPrevChat(String chatroomID);
	
	int getNotReadChatCount(HashMap<String, Object> chatInfo);
}
