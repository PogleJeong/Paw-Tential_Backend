package mul.cam.a.pet.dto;

public class PetDto {
	private int petNum;
	private String id;
	private String cate;
	private String img;
	private String name;
	private String birth;
	private String intro;
	private int gender;
	
	public PetDto() {
	}

	public PetDto(String id, String cate, String img, String name, String birth, String intro, int gender) {
		this.id = id;
		this.cate = cate;
		this.img = img;
		this.name = name;
		this.birth = birth;
		this.intro = intro;
		this.gender = gender;
	}

	public int getPetNum() {
		return petNum;
	}

	public void setPetNum(int petNum) {
		this.petNum = petNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "PetDto [petNum=" + petNum + ", id=" + id + ", cate=" + cate + ", img=" + img + ", name=" + name
				+ ", birth=" + birth + ", intro=" + intro + ", gender=" + gender + "]";
	}
	
}
