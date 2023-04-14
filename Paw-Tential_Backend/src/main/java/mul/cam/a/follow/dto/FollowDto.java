package mul.cam.a.follow.dto;

public class FollowDto {
   private int seq;
   private String id;
   private String follow_id;
   private String fromUser;
  private  String toUser;

  public FollowDto(int seq, String id, String follow_id, String fromUser, String toUser) {
    this.seq = seq;
    this.id = id;
    this.follow_id = follow_id;
    this.fromUser = fromUser;
    this.toUser = toUser;
  }

  public FollowDto() {
    super();
  }

  @Override
  public String toString() {
    return "FollowDto{" +
        "seq=" + seq +
        ", id='" + id + '\'' +
        ", follow_id='" + follow_id + '\'' +
        ", fromUser='" + fromUser + '\'' +
        ", toUser='" + toUser + '\'' +
        '}';
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

  public String getFollow_id() {
    return follow_id;
  }

  public void setFollow_id(String follow_id) {
    this.follow_id = follow_id;
  }

  public String getFromUser() {
    return fromUser;
  }

  public void setFromUser(String fromUser) {
    this.fromUser = fromUser;
  }

  public String getToUser() {
    return toUser;
  }

  public void setToUser(String toUser) {
    this.toUser = toUser;
  }
}
