package mul.cam.a.admin.dto;

//신고 
public class ReportDto {
	

 // 신고 번호 
 private Integer seq;

 // 신고자 아이디 
 private String reporter;

 // 피신고자 아이디 
 private String reported;

 // 내용 
 private String content;

 // 신고 유형 
 private String rtype;

 // 신고일 
 private String rdate;

 // 신고 피드 번호 
 private Integer feedSeq;
 
 public ReportDto() {
	 
 }

 public Integer getSeq() {
     return seq;
 }

 public void setSeq(Integer seq) {
     this.seq = seq;
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

 public String getContent() {
     return content;
 }

 public void setContent(String content) {
     this.content = content;
 }

 public String getRtype() {
     return rtype;
 }

 public void setRtype(String type) {
     this.rtype = type;
 }

 public String getRdate() {
     return rdate;
 }

 public void setRdate(String date) {
     this.rdate = date;
 }

 public Integer getFeedSeq() {
     return feedSeq;
 }

 public void setFeedSeq(Integer feedSeq) {
     this.feedSeq = feedSeq;
 }

public ReportDto(Integer seq, String reporter, String reported, String content, String rtype, String rdate,
		Integer feedSeq) {
	super();
	this.seq = seq;
	this.reporter = reporter;
	this.reported = reported;
	this.content = content;
	this.rtype = rtype;
	this.rdate = rdate;
	this.feedSeq = feedSeq;
}
 
 


}



