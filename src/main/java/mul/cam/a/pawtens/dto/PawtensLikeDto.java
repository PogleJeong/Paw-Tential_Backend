package mul.cam.a.pawtens.dto;

import java.io.Serializable;

public class PawtensLikeDto implements Serializable {
	private int seq;
	private int pawtens_seq;
	private String id;
	
	public PawtensLikeDto() {
	}

	public PawtensLikeDto(int seq, int pawtens_seq, String id) {
		super();
		this.seq = seq;
		this.pawtens_seq = pawtens_seq;
		this.id = id;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getPawtens_seq() {
		return pawtens_seq;
	}

	public void setPawtens_seq(int pawtens_seq) {
		this.pawtens_seq = pawtens_seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PawtensLikeDto [seq=" + seq + ", pawtens_seq=" + pawtens_seq + ", id=" + id + "]";
	}
	
}
