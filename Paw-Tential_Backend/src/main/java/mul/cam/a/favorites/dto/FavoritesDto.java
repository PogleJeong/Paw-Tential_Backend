package mul.cam.a.favorites.dto;

public class FavoritesDto {
    private int seq;
    private int feed_seq;
    private String id;

  public FavoritesDto() {
    super();
  }

  @Override
  public String toString() {
    return "FavoritesDto{" +
        "seq=" + seq +
        ", feed_seq=" + feed_seq +
        ", id='" + id + '\'' +
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
}
