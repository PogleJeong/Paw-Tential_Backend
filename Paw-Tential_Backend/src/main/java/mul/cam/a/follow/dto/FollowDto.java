package mul.cam.a.follow.dto;

public class FollowDto {
  private int seq;
  private String fromUser;
  private String toUser;
  private int id;
  private int count;

  public FollowDto(int seq, String fromUser, String toUser, int id, int count) {
    this.seq = seq;
    this.fromUser = fromUser;
    this.toUser = toUser;
    this.id = id;
    this.count = count;
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
        ", id=" + id +
        ", count=" + count +
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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
