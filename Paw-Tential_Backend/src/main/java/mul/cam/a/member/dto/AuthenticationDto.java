package mul.cam.a.member.dto;

import java.util.Date;

public class AuthenticationDto {
	private String id;
	private String email;
	private String authKey;
	private Date sendDate;
	
	public AuthenticationDto() {
	}
	
	public AuthenticationDto(String id, String email) {
		super();
		this.id = id;
		this.email = email;
	}
	
	public AuthenticationDto(String id, String email, String authKey) {
		super();
		this.id = id;
		this.email = email;
		this.authKey = authKey;
	}

	public AuthenticationDto(String id, String email, String authKey, Date sendDate) {
		super();
		this.id = id;
		this.email = email;
		this.authKey = authKey;
		this.sendDate = sendDate;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAuthKey() {
		return authKey;
	}
	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
	
}
