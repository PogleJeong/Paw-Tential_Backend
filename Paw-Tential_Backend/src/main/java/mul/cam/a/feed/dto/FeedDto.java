package mul.cam.a.feed.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//Main Feed Dto
public class FeedDto implements Serializable {
	
	private String id, content, location, profile;
	private int seq, favoriteCount, commentCount, bookmarkCount;
	@DateTimeFormat(pattern = "yy-MM-dd hh:mm")
	private Date dateCreated, dateUpdated;
	
	public FeedDto() {
		// TODO Auto-generated constructor stub
	}

	public FeedDto(String id, String content, String location, String profile, int seq, int favoriteCount,
			int commentCount, int bookmarkCount, Date dateCreated, Date dateUpdated) {
		super();
		this.id = id;
		this.content = content;
		this.location = location;
		this.profile = profile;
		this.seq = seq;
		this.favoriteCount = favoriteCount;
		this.commentCount = commentCount;
		this.bookmarkCount = bookmarkCount;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getBookmarkCount() {
		return bookmarkCount;
	}

	public void setBookmarkCount(int bookmarkCount) {
		this.bookmarkCount = bookmarkCount;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@Override
	public String toString() {
		return "FeedDto [id=" + id + ", content=" + content + ", location=" + location + ", profile=" + profile
				+ ", seq=" + seq + ", favoriteCount=" + favoriteCount + ", commentCount=" + commentCount
				+ ", bookmarkCount=" + bookmarkCount + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated
				+ "]";
	}
	
}
