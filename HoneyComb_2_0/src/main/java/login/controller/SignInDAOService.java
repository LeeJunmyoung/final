package login.controller;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //Service클래스를 Repository로 등록함으로서 bean클래스로 사용가능
public class SignInDAOService implements SignInDAO {

	@Autowired // Autowired를 사용하여 sqlSession을 사용
	private SqlSession sqlSession;

	@Override
	public ArrayList<LogOnDataBean> getMembers() {
 
		ArrayList<LogOnDataBean> result = new ArrayList<LogOnDataBean>();
		SignInMapper mapper = sqlSession.getMapper(SignInMapper.class);
		result = mapper.getMembers();
		
		return result;
	}
	@Override
	public void insertMember(LogOnDataBean logondb){
		SignInMapper mapper = (SignInMapper) sqlSession.getMapper(LogOnDataBean.class);
		mapper.insertMember(logondb);
	}
}
