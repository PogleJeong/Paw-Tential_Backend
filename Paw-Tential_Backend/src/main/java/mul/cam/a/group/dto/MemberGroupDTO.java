package mul.cam.a.group.dto;

import java.io.Serializable;

public class MemberGroupDTO implements Serializable {
	private String memberId, groupName;
	private int groupId, status;
	
	public MemberGroupDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberGroupDTO(String memberId, String groupName, int groupId, int status) {
		super();
		this.memberId = memberId;
		this.groupName = groupName;
		this.groupId = groupId;
		this.status = status;
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

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MemberGroupDTO [memberId=" + memberId + ", groupName=" + groupName + ", groupId=" + groupId
				+ ", status=" + status + "]";
	}
	
	
	
}
