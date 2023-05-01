package mul.cam.a.feed.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//Main Feed Dto
public class FeedDto implements Serializable {
	private int seq;
	private String id;
	private String content;
	private String tag;
	private String location;
	private String filename;
	private String realpathfile;
	@DateTimeFormat(pattern = "yy-MM-dd hh:mm")
	private Date date_created;
	private Date date_updated;

	public FeedDto() {
	}

	public FeedDto(int seq, String id, String content, String tag, String location) {
		super();
		this.seq = seq;
		this.id = id;
		this.content = content;
		this.tag = tag;
		this.location = location;
	}

	public FeedDto(int seq, String id, String content, String tag, String location, String filename,
			String realpathfile, Date date_created, Date date_updated) {
		super();
		this.seq = seq;
		this.id = id;
		this.content = content;
		this.tag = tag;
		this.location = location;
		this.filename = filename;
		this.realpathfile = realpathfile;
		this.date_created = date_created;
		this.date_updated = date_updated;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getRealpathfile() {
		return realpathfile;
	}

	public void setRealpathfile(String realpathfile) {
		this.realpathfile = realpathfile;
	}

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	public Date getDate_updated() {
		return date_updated;
	}

	public void setDate_updated(Date date_updated) {
		this.date_updated = date_updated;
	}

	@Override
	public String toString() {
		return "FeedDto [seq=" + seq + ", id=" + id + ", content=" + content + ", tag=" + tag + ", location=" + location
				+ ", filename=" + filename + ", realpathfile=" + realpathfile + ", date_created=" + date_created
				+ ", date_updated=" + date_updated + "]";
	}

}
