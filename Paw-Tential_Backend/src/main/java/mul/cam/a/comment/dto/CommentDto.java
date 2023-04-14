package mul.cam.a.comment.dto;

import java.time.LocalDateTime;

public class CommentDto {
  private int seq;
  private int feed_seq;
  private  String id;
  private  String comment;
  private LocalDateTime date_created;
  private LocalDateTime date_updated;

  public CommentDto() {
    super();
  }

  @Override
  public String toString() {
    return "CommentDto{" +
        "seq=" + seq +
        ", feed_seq=" + feed_seq +
        ", id='" + id + '\'' +
        ", comment='" + comment + '\'' +
        ", date_created=" + date_created +
        ", date_updated=" + date_updated +
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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public LocalDateTime getDate_created() {
    return date_created;
  }

  public void setDate_created(LocalDateTime date_created) {
    this.date_created = date_created;
  }

  public LocalDateTime getDate_updated() {
    return date_updated;
  }

  public void setDate_updated(LocalDateTime date_updated) {
    this.date_updated = date_updated;
  }
}
