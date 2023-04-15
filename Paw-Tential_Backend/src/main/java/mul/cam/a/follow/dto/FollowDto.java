package mul.cam.a.follow.dto;

public class FollowDto {
   private int seq;
   private String fromUser;
  private  String toUser;

  private  Integer count;

  public FollowDto(int seq, String id, String follow_id, String fromUser, String toUser) {
    this.seq = seq;
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
