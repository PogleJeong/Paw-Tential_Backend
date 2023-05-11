package mul.cam.a.pawtens.dto;

import java.util.Date;

public class PawtensDto {
	private int seq;
	private String id;
	private String content;
	private Date date_created;
	private Date date_updated;
	private String filename;
	private String realpathfile;
	
	public PawtensDto() {
	}
	
	public PawtensDto(String id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public PawtensDto(int seq, String id, String content, Date date_created, Date date_updated, String filename,
			String realpathfile) {
		super();
		this.seq = seq;
		this.id = id;
		this.content = content;
		this.date_created = date_created;
		this.date_updated = date_updated;
		this.filename = filename;
		this.realpathfile = realpathfile;
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

	@Override
	public String toString() {
		return "PawtensDto [seq=" + seq + ", id=" + id + ", content=" + content + ", date_created=" + date_created
				+ ", date_updated=" + date_updated + ", filename=" + filename + ", realpathfile=" + realpathfile + "]";
	}
	
}
