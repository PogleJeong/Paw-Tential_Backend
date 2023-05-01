package mul.cam.a.group.dto;

import java.io.Serializable;

public class CareGroupFeedDTO implements Serializable {

	private int grpNo;
	private int careGrpFeedNo;
	private String careGrpType;
	private String careGrpStartDt;
	private String careGrpEndDt;
	private String careGrpStartTime;
	private String careGrpEndTime;
	private String careGrpCheck;
	private String careGrpContent;
	private String careGrpFeedSetting;
	private String careGrpFeedWriter;
	private String careGrpFeedWd;

	public CareGroupFeedDTO() {
		// TODO Auto-generated constructor stub
	}

	public CareGroupFeedDTO(int grpNo, int careGrpFeedNo, String careGrpType, String careGrpStartDt,
			String careGrpEndDt, String careGrpStartTime, String careGrpEndTime, String careGrpCheck,
			String careGrpContent, String careGrpFeedSetting, String careGrpFeedWriter, String careGrpFeedWd) {
		super();
		this.grpNo = grpNo;
		this.careGrpFeedNo = careGrpFeedNo;
		this.careGrpType = careGrpType;
		this.careGrpStartDt = careGrpStartDt;
		this.careGrpEndDt = careGrpEndDt;
		this.careGrpStartTime = careGrpStartTime;
		this.careGrpEndTime = careGrpEndTime;
		this.careGrpCheck = careGrpCheck;
		this.careGrpContent = careGrpContent;
		this.careGrpFeedSetting = careGrpFeedSetting;
		this.careGrpFeedWriter = careGrpFeedWriter;
		this.careGrpFeedWd = careGrpFeedWd;
	}

	public int getGrpNo() {
		return grpNo;
	}

	public void setGrpNo(int grpNo) {
		this.grpNo = grpNo;
	}

	public int getCareGrpFeedNo() {
		return careGrpFeedNo;
	}

	public void setCareGrpFeedNo(int careGrpFeedNo) {
		this.careGrpFeedNo = careGrpFeedNo;
	}

	public String getCareGrpType() {
		return careGrpType;
	}

	public void setCareGrpType(String careGrpType) {
		this.careGrpType = careGrpType;
	}

	public String getCareGrpStartDt() {
		return careGrpStartDt;
	}

	public void setCareGrpStartDt(String careGrpStartDt) {
		this.careGrpStartDt = careGrpStartDt;
	}

	public String getCareGrpEndDt() {
		return careGrpEndDt;
	}

	public void setCareGrpEndDt(String careGrpEndDt) {
		this.careGrpEndDt = careGrpEndDt;
	}

	public String getCareGrpStartTime() {
		return careGrpStartTime;
	}

	public void setCareGrpStartTime(String careGrpStartTime) {
		this.careGrpStartTime = careGrpStartTime;
	}

	public String getCareGrpEndTime() {
		return careGrpEndTime;
	}

	public void setCareGrpEndTime(String careGrpEndTime) {
		this.careGrpEndTime = careGrpEndTime;
	}

	public String getCareGrpCheck() {
		return careGrpCheck;
	}

	public void setCareGrpCheck(String careGrpCheck) {
		this.careGrpCheck = careGrpCheck;
	}

	public String getCareGrpContent() {
		return careGrpContent;
	}

	public void setCareGrpContent(String careGrpContent) {
		this.careGrpContent = careGrpContent;
	}

	public String getCareGrpFeedSetting() {
		return careGrpFeedSetting;
	}

	public void setCareGrpFeedSetting(String careGrpFeedSetting) {
		this.careGrpFeedSetting = careGrpFeedSetting;
	}

	public String getCareGrpFeedWriter() {
		return careGrpFeedWriter;
	}

	public void setCareGrpFeedWriter(String careGrpFeedWriter) {
		this.careGrpFeedWriter = careGrpFeedWriter;
	}

	public String getCareGrpFeedWd() {
		return careGrpFeedWd;
	}

	public void setCareGrpFeedWd(String careGrpFeedWd) {
		this.careGrpFeedWd = careGrpFeedWd;
	}

	@Override
	public String toString() {
		return "CareGroupFeedDTO [grpNo=" + grpNo + ", careGrpFeedNo=" + careGrpFeedNo + ", careGrpType=" + careGrpType
				+ ", careGrpStartDt=" + careGrpStartDt + ", careGrpEndDt=" + careGrpEndDt + ", careGrpStartTime="
				+ careGrpStartTime + ", careGrpEndTime=" + careGrpEndTime + ", careGrpCheck=" + careGrpCheck
				+ ", careGrpContent=" + careGrpContent + ", careGrpFeedSetting=" + careGrpFeedSetting
				+ ", careGrpFeedWriter=" + careGrpFeedWriter + ", careGrpFeedWd=" + careGrpFeedWd + "]";
	}
	
}
