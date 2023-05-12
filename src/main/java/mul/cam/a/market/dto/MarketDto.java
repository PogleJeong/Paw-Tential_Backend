package mul.cam.a.market.dto;

import java.util.Date;

public class MarketDto {
	private String title;
	private String content;
	private Date wdate;
	private String id;
	private String state;
	private String category;
	private String productName;
	private int productNumber;
	private String conditions;
	private String file;
	private String price;
	private int del;
	private int report;
	private int posting;
	private String geoLat;
	private String geoLng;

	public MarketDto() {
		// TODO Auto-generated constructor stub
	}

	public MarketDto(String title, String content, String id, String state, String category, String productName,
			int productNumber, String conditions, String geoLat, String geoLng) {
		super();
		this.title = title;
		this.content = content;
		this.id = id;
		this.state = state;
		this.category = category;
		this.productName = productName;
		this.productNumber = productNumber;
		this.conditions = conditions;
		this.geoLat = geoLat;
		this.geoLng = geoLng;
	}

	public MarketDto(String title, String content, Date wdate, String id, String state, String category,
			String productName, int productNumber, String conditions, String file, String price,
			int del, int report, int posting) {
		super();
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.id = id;
		this.state = state;
		this.category = category;
		this.productName = productName;
		this.productNumber = productNumber;
		this.conditions = conditions;
		this.file = file;
		this.price = price;
		this.del = del;
		this.report = report;
		this.posting = posting;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getReport() {
		return report;
	}

	public void setReport(int report) {
		this.report = report;
	}
	
	public int getPosting() {
		return posting;
	}

	public void setPosting(int posting) {
		this.posting = posting;
	}

	public String getGeoLat() {
		return geoLat;
	}

	public void setGeoLat(String geoLat) {
		this.geoLat = geoLat;
	}

	public String getGeoLng() {
		return geoLng;
	}

	public void setGeoLng(String geoLng) {
		this.geoLng = geoLng;
	}

	@Override
	public String toString() {
		return "MarketDto [title=" + title + ", content=" + content + ", wdate=" + wdate + ", id=" + id + ", state="
				+ state + ", category=" + category + ", productName=" + productName + ", productNumber=" + productNumber
				+ ", conditions=" + conditions + ", file=" + file + ", price=" + price + ", del=" + del
				+ ", report=" + report + ", posting=" + posting + ", geoLat=" + geoLat + ", geoLng=" + geoLng + "]";
	}
}
