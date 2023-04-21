package mul.cam.a.bookmark.dto;

public class BookmarkDto {
  private int seq;
  private int feed_seq;
  private String feed_id;

  public BookmarkDto(int seq, int feed_seq, String feed_id) {
    this.seq = seq;
    this.feed_seq = feed_seq;
    this.feed_id = feed_id;
  }

  public BookmarkDto() {
    super();
  }

  @Override
  public String toString() {
    return "BookmarkDto{" +
        "seq=" + seq +
        ", feed_seq=" + feed_seq +
        ", feed_id='" + feed_id + '\'' +
        '}';
  }

  public int getSeq() {
    return seq;
  }

  public void setSeq(int seq) {
    this.seq = seq;
  }

  public int getFeed_seq() {
    return feed_seq;
  }

  public void setFeed_seq(int feed_seq) {
    this.feed_seq = feed_seq;
  }

  public String getFeed_id() {
    return feed_id;
  }

  public void setFeed_id(String feed_id) {
    this.feed_id = feed_id;
  }
}

