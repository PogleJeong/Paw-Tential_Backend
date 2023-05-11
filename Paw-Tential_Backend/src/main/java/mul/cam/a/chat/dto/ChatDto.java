package mul.cam.a.chat.dto;

import java.util.Date;

public class ChatDto {
	private String chatroomID;
	private String sender;
	private String recipient;
	private Date sendDate;
	private String isViewed;
	private String message;
	
	public ChatDto() {
		
	}
	
	public ChatDto(String chatroomID, String sender, String recipient, Date sendDate, String isViewed, String message) {
		this.chatroomID = chatroomID;
		this.sender = sender;
		this.recipient = recipient;
		this.sendDate = sendDate;
		this.isViewed = isViewed;
		this.message = message;
	}
	
	public String getChatroomID() {
		return chatroomID;
	}
	public void setChatroomID(String chatroomID) {
		this.chatroomID = chatroomID;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getIsViewed() {
		return isViewed;
	}
	public void setIsViewed(String isViewed) {
		this.isViewed = isViewed;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ChatDto [ChatroomID=" + chatroomID + ", sender=" + sender + ", recipient=" + recipient + ", sendDate="
				+ sendDate + ", isViewed=" + isViewed + ", massage=" + message + "]";
	}
}
