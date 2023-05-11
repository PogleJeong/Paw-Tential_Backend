package mul.cam.a.group.dto;

import java.io.Serializable;

public class GroupDTO implements Serializable {
	
	private int grpNo, grpMember, grpVisit, grpPost, grpStatus, grpIsOfficial;
	private String grpName, grpLeader, image, grpIntro, grpImage;
	
	public GroupDTO() {
		// TODO Auto-generated constructor stub
	}

	public GroupDTO(int grpNo, int grpMember, int grpVisit, int grpPost, int grpStatus, int grpIsOfficial,
			String grpName, String grpLeader, String image, String grpIntro, String grpImage) {
		super();
		this.grpNo = grpNo;
		this.grpMember = grpMember;
		this.grpVisit = grpVisit;
		this.grpPost = grpPost;
		this.grpStatus = grpStatus;
		this.grpIsOfficial = grpIsOfficial;
		this.grpName = grpName;
		this.grpLeader = grpLeader;
		this.image = image;
		this.grpIntro = grpIntro;
		this.grpImage = grpImage;
	}

	public int getGrpNo() {
		return grpNo;
	}

	public void setGrpNo(int grpNo) {
		this.grpNo = grpNo;
	}

	public int getGrpMember() {
		return grpMember;
	}

	public void setGrpMember(int grpMember) {
		this.grpMember = grpMember;
	}

	public int getGrpVisit() {
		return grpVisit;
	}

	public void setGrpVisit(int grpVisit) {
		this.grpVisit = grpVisit;
	}

	public int getGrpPost() {
		return grpPost;
	}

	public void setGrpPost(int grpPost) {
		this.grpPost = grpPost;
	}

	public int getGrpStatus() {
		return grpStatus;
	}

	public void setGrpStatus(int grpStatus) {
		this.grpStatus = grpStatus;
	}

	public int getGrpIsOfficial() {
		return grpIsOfficial;
	}

	public void setGrpIsOfficial(int grpIsOfficial) {
		this.grpIsOfficial = grpIsOfficial;
	}

	public String getGrpName() {
		return grpName;
	}

	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}

	public String getGrpLeader() {
		return grpLeader;
	}

	public void setGrpLeader(String grpLeader) {
		this.grpLeader = grpLeader;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGrpIntro() {
		return grpIntro;
	}

	public void setGrpIntro(String grpIntro) {
		this.grpIntro = grpIntro;
	}

	public String getGrpImage() {
		return grpImage;
	}

	public void setGrpImage(String grpImage) {
		this.grpImage = grpImage;
	}

	@Override
	public String toString() {
		return "GroupDTO [grpNo=" + grpNo + ", grpMember=" + grpMember + ", grpVisit=" + grpVisit + ", grpPost="
				+ grpPost + ", grpStatus=" + grpStatus + ", grpIsOfficial=" + grpIsOfficial + ", grpName=" + grpName
				+ ", grpLeader=" + grpLeader + ", image=" + image + ", grpIntro=" + grpIntro + ", grpImage=" + grpImage
				+ "]";
	}
	
}
