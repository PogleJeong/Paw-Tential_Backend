package mul.cam.a.group.dto;

import java.io.Serializable;

public class GroupSearchParam implements Serializable {

	private String memberId;
	private String groupName;
	
	public GroupSearchParam() {
		// TODO Auto-generated constructor stub
	}

	public GroupSearchParam(String memberId, String groupName) {
		super();
		this.memberId = memberId;
		this.groupName = groupName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "GroupSearchParam [memberId=" + memberId + ", groupName=" + groupName + "]";
	}
	
}
