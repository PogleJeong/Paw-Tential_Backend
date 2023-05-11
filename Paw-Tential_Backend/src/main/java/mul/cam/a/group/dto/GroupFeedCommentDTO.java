package mul.cam.a.group.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class GroupFeedCommentDTO implements Serializable {
	
	private int grpFeedNo, grpCmtNo, grpFeedCmtRef, grpFeedCmtDepth, grpFeedCmtStep;
	private String grpFeedCmtId, grpFeedCmtContent, profile;
	@DateTimeFormat(pattern = "yy-MM-dd hh:mm")
	private Date grpFeedCmtWd;
	
	public GroupFeedCommentDTO() {
		// TODO Auto-generated constructor stub
	}

	public GroupFeedCommentDTO(int grpFeedNo, int grpCmtNo, int grpFeedCmtRef, int grpFeedCmtDepth, int grpFeedCmtStep,
			String grpFeedCmtId, String grpFeedCmtContent, String profile, Date grpFeedCmtWd) {
		super();
		this.grpFeedNo = grpFeedNo;
		this.grpCmtNo = grpCmtNo;
		this.grpFeedCmtRef = grpFeedCmtRef;
		this.grpFeedCmtDepth = grpFeedCmtDepth;
		this.grpFeedCmtStep = grpFeedCmtStep;
		this.grpFeedCmtId = grpFeedCmtId;
		this.grpFeedCmtContent = grpFeedCmtContent;
		this.profile = profile;
		this.grpFeedCmtWd = grpFeedCmtWd;
	}

	public int getGrpFeedNo() {
		return grpFeedNo;
	}

	public void setGrpFeedNo(int grpFeedNo) {
		this.grpFeedNo = grpFeedNo;
	}

	public int getGrpCmtNo() {
		return grpCmtNo;
	}

	public void setGrpCmtNo(int grpCmtNo) {
		this.grpCmtNo = grpCmtNo;
	}

	public int getGrpFeedCmtRef() {
		return grpFeedCmtRef;
	}

	public void setGrpFeedCmtRef(int grpFeedCmtRef) {
		this.grpFeedCmtRef = grpFeedCmtRef;
	}

	public int getGrpFeedCmtDepth() {
		return grpFeedCmtDepth;
	}

	public void setGrpFeedCmtDepth(int grpFeedCmtDepth) {
		this.grpFeedCmtDepth = grpFeedCmtDepth;
	}

	public int getGrpFeedCmtStep() {
		return grpFeedCmtStep;
	}

	public void setGrpFeedCmtStep(int grpFeedCmtStep) {
		this.grpFeedCmtStep = grpFeedCmtStep;
	}

	public String getGrpFeedCmtId() {
		return grpFeedCmtId;
	}

	public void setGrpFeedCmtId(String grpFeedCmtId) {
		this.grpFeedCmtId = grpFeedCmtId;
	}

	public String getGrpFeedCmtContent() {
		return grpFeedCmtContent;
	}

	public void setGrpFeedCmtContent(String grpFeedCmtContent) {
		this.grpFeedCmtContent = grpFeedCmtContent;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Date getGrpFeedCmtWd() {
		return grpFeedCmtWd;
	}

	public void setGrpFeedCmtWd(Date grpFeedCmtWd) {
		this.grpFeedCmtWd = grpFeedCmtWd;
	}

	@Override
	public String toString() {
		return "GroupFeedCommentDTO [grpFeedNo=" + grpFeedNo + ", grpCmtNo=" + grpCmtNo + ", grpFeedCmtRef="
				+ grpFeedCmtRef + ", grpFeedCmtDepth=" + grpFeedCmtDepth + ", grpFeedCmtStep=" + grpFeedCmtStep
				+ ", grpFeedCmtId=" + grpFeedCmtId + ", grpFeedCmtContent=" + grpFeedCmtContent + ", profile=" + profile
				+ ", grpFeedCmtWd=" + grpFeedCmtWd + "]";
	}
	
}
