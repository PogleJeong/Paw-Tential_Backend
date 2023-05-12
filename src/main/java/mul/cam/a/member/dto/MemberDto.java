package mul.cam.a.member.dto;

import java.util.Date;

public class MemberDto {
	private String id;
	private String pwd;
	private String email;
	private String nickname;
	private String phone;
	private String birth;
	private int gender;
	private String profile;
	private String intro;
	private int petHave;
	private int status;
	private Date regiDate;
	private String groupId;
	private int groupStatus;
	private int auth;
	
	public MemberDto() {
		
	}
	
	public MemberDto(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	

	public MemberDto(String id, String email, String nickname) {
		this.id = id;
		this.email = email;
		this.nickname = nickname;
	}

	public MemberDto(String id, String pwd, String email, String nickname, String phone, String birth, int gender, int petHave) {
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.nickname = nickname;
		this.phone = phone;
		this.birth = birth;
		this.gender = gender;
		this.petHave = petHave;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public int getPetHave() {
		return petHave;
	}
	public void setPetHave(int petHave) {
		this.petHave = petHave;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public int getGroupStatus() {
		return groupStatus;
	}
	public void setGroupStatus(int groupStatus) {
		this.groupStatus = groupStatus;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pwd=" + pwd + ", email=" + email + ", nickname=" + nickname + ", phone="
				+ phone + ", birth=" + birth + ", gender=" + gender + ", profile=" + profile + ", intro=" + intro
				+ ", petHave=" + petHave + ", status=" + status + ", regiDate=" + regiDate + ", groupId=" + groupId
				+ ", groupStatus=" + groupStatus + ", auth=" + auth + "]";
	}
}
