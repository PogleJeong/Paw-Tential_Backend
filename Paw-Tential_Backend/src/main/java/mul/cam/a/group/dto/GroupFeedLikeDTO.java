package mul.cam.a.group.dto;

import java.io.Serializable;

public class GroupFeedLikeDTO implements Serializable {
	private int grpFeedNo;
	private String grpFeedLikeId;
	
	public GroupFeedLikeDTO() {
		// TODO Auto-generated constructor stub
	}

	public GroupFeedLikeDTO(int grpFeedNo, String grpFeedLikeId) {
		super();
		this.grpFeedNo = grpFeedNo;
		this.grpFeedLikeId = grpFeedLikeId;
	}

	public int getGrpFeedNo() {
		return grpFeedNo;
	}

	public void setGrpFeedNo(int grpFeedNo) {
		this.grpFeedNo = grpFeedNo;
	}

	public String getGrpFeedLikeId() {
		return grpFeedLikeId;
	}

	public void setGrpFeedLikeId(String grpFeedLikeId) {
		this.grpFeedLikeId = grpFeedLikeId;
	}

	@Override
	public String toString() {
		return "GroupFeedLike [grpFeedNo=" + grpFeedNo + ", grpFeedLikeId=" + grpFeedLikeId + "]";
	}
	

}
