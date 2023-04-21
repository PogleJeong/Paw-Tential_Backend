package mul.cam.a.admin.dto;

public class QnADto {
	
	private int seq;
	private String content;
	private String id;
	private int whether;
	private String email;
	private String wdate;
	
	public QnADto() {
		
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getWhether() {
		return whether;
	}

	public void setWhether(int whether) {
		this.whether = whether;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public QnADto(int seq, String content, String id, int whether, String email, String wdate) {
		super();
		this.seq = seq;
		this.content = content;
		this.id = id;
		this.whether = whether;
		this.email = email;
		this.wdate = wdate;
	}
	
	

}
