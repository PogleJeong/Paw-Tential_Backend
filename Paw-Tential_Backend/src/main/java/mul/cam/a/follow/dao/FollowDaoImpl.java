package mul.cam.a.follow.dao;

import mul.cam.a.follow.dto.FollowDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FollowDaoImpl implements FollowDao {

@Autowired
  SqlSession session;

String ns = "Follow.";

/*
public List <FollowDto> getAllFollowId(String id){
  return session.selectList(ns + "getAllFollowId",id);
}
 */

  public List <FollowDto> getAllToUsers(String toUser){

    return session.selectList(ns + "getAllToUsers", toUser);
  }
//insert
  public void addFollowToUser(FollowDto followDto) {
    session.insert(ns + "addFollowToUser", followDto);
  }

  @Override
  public void update(FollowDto followDto) {
    session.update(ns + "updateFollow", followDto);
  }

  @Override
  public void delete(Integer seq) {
    session.delete(ns + "deleteFollow", seq);
  }

  public FollowDto getBySeq(Integer seq) {
    return session.selectOne(ns + "getBySeq", seq);
  }
}
