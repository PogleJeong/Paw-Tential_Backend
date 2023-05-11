package mul.cam.a.comment.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CommentDto {

	private int seq, feedSeq;
	private String id, comment, profile;
	@DateTimeFormat(pattern = "yy-MM-dd hh:mm")
	private Date dateCreated, dateUpdated;

	public CommentDto() {
		// TODO Auto-generated constructor stub
	}

	public CommentDto(int seq, int feedSeq, String id, String comment, String profile, Date dateCreated,
			Date dateUpdated) {
		super();
		this.seq = seq;
		this.feedSeq = feedSeq;
		this.id = id;
		this.comment = comment;
		this.profile = profile;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getFeedSeq() {
		return feedSeq;
	}

	public void setFeedSeq(int feedSeq) {
		this.feedSeq = feedSeq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
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
		return "CommentDto [seq=" + seq + ", feedSeq=" + feedSeq + ", id=" + id + ", comment=" + comment + ", profile="
				+ profile + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + "]";
	}
	

}
