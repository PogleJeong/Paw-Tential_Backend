package mul.cam.a.member.dto;

import java.io.Serializable;

public class MemberDto implements Serializable{

	    // 아이디 아이디
	    private String id;

	    // 비밀번호 비밀번호
	    private String pwd;

	    // 이메일 이메일
	    private String email;

	    // 닉네임 닉네임
	    private String nickname;

	    // 전화번호 전화번호
	    private String phone;

	    // 생년월일 생년월일
	    private String birth;

	    // 성별(남0 여1) 성별(남0 여1)
	    private int gender;

	    // 프로필 이미지 프로필 이미지
	    private String profile;

	    // 자기소개 자기소개
	    private String intro;

	    // 반려동물 여부(없다 0 있다 1) 반려동물 여부(없다 0 있다 1)
	    private int petHave;

	    // 회원 상태(0 정상 1 정지) 회원 상태(0 정상 1 정지)
	    private int status;

	    // 회원 가입 날짜 회원 가입 날짜
	    private String regiDate;

	    // 그룹 ID 그룹 ID
	    private String groupId;

	    // 그룹 가입여부(가입x 0, 가입o 1) 그룹 가입여부(가입x 0, 가입o 1)
	    private int groupStatus;

	    // 일반(0) 관리자(1) 일반(0) 관리자(1)
	    private int auth;
	    
	    public MemberDto() {
	    	
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

		public String getRegiDate() {
			return regiDate;
		}

		public void setRegiDate(String regiDate) {
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

		public MemberDto(String id, String pwd, String email, String nickname, String phone, String birth, int gender,
				String profile, String intro, int petHave, int status, String regiDate, String groupId, int groupStatus,
				int auth) {
			super();
			this.id = id;
			this.pwd = pwd;
			this.email = email;
			this.nickname = nickname;
			this.phone = phone;
			this.birth = birth;
			this.gender = gender;
			this.profile = profile;
			this.intro = intro;
			this.petHave = petHave;
			this.status = status;
			this.regiDate = regiDate;
			this.groupId = groupId;
			this.groupStatus = groupStatus;
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
