package mul.cam.a.member.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.member.dto.AuthenticationDto;
import mul.cam.a.member.dto.MemberDto;

@Mapper
@Repository
public interface MemberDao {
	int idCheck(String id);
	int nicknameCheck(String nickname);
	
	MemberDto login(MemberDto member);
	int addMember(MemberDto member);
	String findId(HashMap<String, Object> emailAndPhone);
	int resetPassword(MemberDto member);
	
	MemberDto idAndEmailCheck(HashMap<String, Object> idAndEmail);
	
	int checkExistEmailAuth(AuthenticationDto authentication);
	int addEmailAuth(AuthenticationDto authentication);
	int updateEmailAuth(AuthenticationDto authentication);
	int deleteAuthKeyAfterConfirm(AuthenticationDto authentication);
	int confirmAuthKey(AuthenticationDto authentication);
	

}
