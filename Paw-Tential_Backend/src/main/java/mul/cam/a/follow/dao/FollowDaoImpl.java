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

public List <FollowDto> getAllFollowId(String id){
  return session.selectList(ns + "getAllFollowId",id);
}


}
