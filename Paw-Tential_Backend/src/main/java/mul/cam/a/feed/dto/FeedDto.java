package mul.cam.a.feed.dto;

import java.time.LocalDateTime;

//Main Feed Dto
public class FeedDto {
      private String id;
      private String content;
      private String tag;
      private String location;
      private String filename;
      private String realpathfile;
      private LocalDateTime date_created;
      private LocalDateTime date_updated;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String getRealpathfile() {
    return realpathfile;
  }

  public void setRealpathfile(String realpathfile) {
    this.realpathfile = realpathfile;
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

  public FeedDto(String id, String content, String tag, String location, String filename, String realpathfile, LocalDateTime date_created, LocalDateTime date_updated) {
    this.id = id;
    this.content = content;
    this.tag = tag;
    this.location = location;
    this.filename = filename;
    this.realpathfile = realpathfile;
    this.date_created = date_created;
    this.date_updated = date_updated;
  }

  public FeedDto() {
    super();
  }

  @Override
  public String toString() {
    return "BoardDto{" +
        "id='" + id + '\'' +
        ", content='" + content + '\'' +
        ", tag='" + tag + '\'' +
        ", location='" + location + '\'' +
        ", filename='" + filename + '\'' +
        ", realpathfile='" + realpathfile + '\'' +
        ", date_created=" + date_created +
        ", date_updated=" + date_updated +
        '}';
  }
}
