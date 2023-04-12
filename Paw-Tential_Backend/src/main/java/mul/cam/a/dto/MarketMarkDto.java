package mul.cam.a.dto;

public class MarketMarkDto {
	private int posting;
	private String id;
	
	public MarketMarkDto() {
	}
	
	public MarketMarkDto(int posting, String id) {
		super();
		this.posting = posting;
		this.id = id;
	}

	public int getPosting() {
		return posting;
	}

	public void setPosting(int posting) {
		this.posting = posting;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
