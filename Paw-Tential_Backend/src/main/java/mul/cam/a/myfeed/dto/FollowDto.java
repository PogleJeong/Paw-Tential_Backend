package mul.cam.a.myfeed.dto;

public class FollowDto {
	
	private int id; 
	private String follower_id;
	private String following_id;
	
	public FollowDto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFollower_id() {
	    return follower_id;
	}

	public void setFollower_id(String follower_id) {
		this.follower_id = follower_id;
	}

	public String getFollowing_id() {
		return following_id;
	}

	public void setFollowing_id(String following_id) {
		this.following_id = following_id;
	}

	public FollowDto(int id, String follower_id, String following_id) {
		super();
		this.id = id;
		this.follower_id = follower_id;
		this.following_id = following_id;
	}
}
