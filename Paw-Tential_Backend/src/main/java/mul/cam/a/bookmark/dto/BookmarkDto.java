package mul.cam.a.bookmark.dto;

import java.io.Serializable;

public class BookmarkDto implements Serializable {

	private int seq, feedSeq;
	private String id;

	public BookmarkDto() {
		// TODO Auto-generated constructor stub
	}

	public BookmarkDto(int seq, int feedSeq, String id) {
		super();
		this.seq = seq;
		this.feedSeq = feedSeq;
		this.id = id;
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

	@Override
	public String toString() {
		return "BookmarkDto [seq=" + seq + ", feedSeq=" + feedSeq + ", id=" + id + "]";
	}
	
}
