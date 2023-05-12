package mul.cam.a.chat.dto;

public class ChatroomDto {
	private String chatroomID;
	private String participant1;
	private String participant2;
	
	public ChatroomDto() {	
	}
	public ChatroomDto(String chatroomID, String participant1, String participant2) {
		this.chatroomID = chatroomID;
		this.participant1 = participant1;
		this.participant2 = participant2;
	}
	public String getChatroomID() {
		return chatroomID;
	}

	public void setChatroomID(String chatroomID) {
		this.chatroomID = chatroomID;
	}

	public String getParticipant1() {
		return participant1;
	}

	public void setParticipant1(String participant1) {
		this.participant1 = participant1;
	}

	public String getParticipant2() {
		return participant2;
	}

	public void setParticipant2(String participant2) {
		this.participant2 = participant2;
	}
	@Override
	public String toString() {
		return "ChatroomDto [chatroomID=" + chatroomID + ", participant1=" + participant1 + ", participant2="
				+ participant2 + "]";
	}
	
}
