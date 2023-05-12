package mul.cam.a.favorites.dto;

public class FavoritesDto {
  private int seq;
  private int feed_seq;
  private String id;

  private int feed_like;



  public FavoritesDto(int seq, int feed_seq, String id, int feed_like) {
    this.seq = seq;
    this.feed_seq = feed_seq;
    this.id = id;
    this.feed_like = feed_like;
  }


  @Override
  public String toString() {
    return "FavoritesDto{" +
        "seq=" + seq +
        ", feed_seq=" + feed_seq +
        ", id='" + id + '\'' +
        ", feed_like=" + feed_like +
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

  public int getFeed_like() {
    return feed_like;
  }

  public void setFeed_like(int feed_like) {
    this.feed_like = feed_like;
  }
}