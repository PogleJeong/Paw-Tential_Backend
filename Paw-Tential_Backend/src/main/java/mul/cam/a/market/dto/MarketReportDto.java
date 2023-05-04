package mul.cam.a.market.dto;

public class MarketReportDto {
	private String title;
	private String reporter;
	private String reported;
	private String category;
	private String content;
	private String url;
	
	public MarketReportDto(String title, String reporter, String reported, String category, String content,
			String url) {
		super();
		this.title = title;
		this.reporter = reporter;
		this.reported = reported;
		this.category = category;
		this.content = content;
		this.url = url;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getReported() {
		return reported;
	}
	public void setReported(String reported) {
		this.reported = reported;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "MarketReportDto [title=" + title + ", reporter=" + reporter + ", reported=" + reported + ", category="
				+ category + ", content=" + content + ", url=" + url + "]";
	}
}
