package mul.cam.a.group.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class GroupFeedDTO implements Serializable {

	private int grpNo, grpFeedNo, grpFeedLikeCount, grpCommentCount;
	private String grpName, grpFeedContent, grpFeedSetting, grpFeedId, profile;
	@DateTimeFormat(pattern = "yy-MM-dd hh:mm")
	private Date grpFeedWd;
	
	public GroupFeedDTO() {
		// TODO Auto-generated constructor stub
	}

	public GroupFeedDTO(int grpNo, int grpFeedNo, int grpFeedLikeCount, int grpCommentCount, String grpName,
			String grpFeedContent, String grpFeedSetting, String grpFeedId, String profile, Date grpFeedWd) {
		super();
		this.grpNo = grpNo;
		this.grpFeedNo = grpFeedNo;
		this.grpFeedLikeCount = grpFeedLikeCount;
		this.grpCommentCount = grpCommentCount;
		this.grpName = grpName;
		this.grpFeedContent = grpFeedContent;
		this.grpFeedSetting = grpFeedSetting;
		this.grpFeedId = grpFeedId;
		this.profile = profile;
		this.grpFeedWd = grpFeedWd;
	}

	public int getGrpNo() {
		return grpNo;
	}

	public void setGrpNo(int grpNo) {
		this.grpNo = grpNo;
	}

	public int getGrpFeedNo() {
		return grpFeedNo;
	}

	public void setGrpFeedNo(int grpFeedNo) {
		this.grpFeedNo = grpFeedNo;
	}

	public int getGrpFeedLikeCount() {
		return grpFeedLikeCount;
	}

	public void setGrpFeedLikeCount(int grpFeedLikeCount) {
		this.grpFeedLikeCount = grpFeedLikeCount;
	}

	public int getGrpCommentCount() {
		return grpCommentCount;
	}

	public void setGrpCommentCount(int grpCommentCount) {
		this.grpCommentCount = grpCommentCount;
	}

	public String getGrpName() {
		return grpName;
	}

	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}

	public String getGrpFeedContent() {
		return grpFeedContent;
	}

	public void setGrpFeedContent(String grpFeedContent) {
		this.grpFeedContent = grpFeedContent;
	}

	public String getGrpFeedSetting() {
		return grpFeedSetting;
	}

	public void setGrpFeedSetting(String grpFeedSetting) {
		this.grpFeedSetting = grpFeedSetting;
	}

	public String getGrpFeedId() {
		return grpFeedId;
	}

	public void setGrpFeedId(String grpFeedId) {
		this.grpFeedId = grpFeedId;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Date getGrpFeedWd() {
		return grpFeedWd;
	}

	public void setGrpFeedWd(Date grpFeedWd) {
		this.grpFeedWd = grpFeedWd;
	}

	@Override
	public String toString() {
		return "GroupFeedDTO [grpNo=" + grpNo + ", grpFeedNo=" + grpFeedNo + ", grpFeedLikeCount=" + grpFeedLikeCount
				+ ", grpCommentCount=" + grpCommentCount + ", grpName=" + grpName + ", grpFeedContent=" + grpFeedContent
				+ ", grpFeedSetting=" + grpFeedSetting + ", grpFeedId=" + grpFeedId + ", profile=" + profile
				+ ", grpFeedWd=" + grpFeedWd + "]";
	}
	
}
