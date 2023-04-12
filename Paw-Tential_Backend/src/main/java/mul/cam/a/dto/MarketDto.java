package mul.cam.a.dto;

import java.util.Date;

public class MarketDto {
	private String title;
	private String content;
	private Date wdate;
	private String statement;
	private String id;
	private String product;
	private String category;
	private int number;
	private String condition;
	private String view;
	private String file;
	private String realpathfile;
	private int del;
	private int report;
	private String liker;
	
	
	public MarketDto() {
		// TODO Auto-generated constructor stub
	}
	
	public MarketDto(String title, String content, Date wdate, String statement, String id, String product,
			String category, int number, String condition, String view, String file, String realpathfile, int del,
			int report, String liker) {
		super();
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.statement = statement;
		this.id = id;
		this.product = product;
		this.category = category;
		this.number = number;
		this.condition = condition;
		this.view = view;
		this.file = file;
		this.realpathfile = realpathfile;
		this.del = del;
		this.report = report;
		this.liker = liker;
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


	public String getStatement() {
		return statement;
	}


	public void setStatement(String statement) {
		this.statement = statement;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}


	public String getView() {
		return view;
	}


	public void setView(String view) {
		this.view = view;
	}


	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}


	public String getRealpathfile() {
		return realpathfile;
	}


	public void setRealpathfile(String realpathfile) {
		this.realpathfile = realpathfile;
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


	public String getLiker() {
		return liker;
	}


	public void setLiker(String liker) {
		this.liker = liker;
	}

	@Override
	public String toString() {
		return "MarketDto [title=" + title + ", content=" + content + ", wdate=" + wdate + ", statement=" + statement
				+ ", id=" + id + ", product=" + product + ", category=" + category + ", number=" + number
				+ ", condition=" + condition + ", view=" + view + ", file=" + file + ", realpathfile=" + realpathfile
				+ ", del=" + del + ", report=" + report + ", liker=" + liker + "]";
	}
	
	
	
}
