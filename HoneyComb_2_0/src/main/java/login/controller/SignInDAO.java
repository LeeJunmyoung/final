package login.controller;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class SignInDAO extends SqlSessionDaoSupport {
	
	public List<LogOnDataBean> getMembers(){
		return getSqlSession().selectList("login.getMembers");
	}
	public void insertMember(LogOnDataBean logdb){
		
		getSqlSession().insert("insertMember",logdb);
	
	}
	public String getCheckUserId(String email) {
		return this.getSqlSession().selectOne("mailCheck", email);
	}
	
	
	
}
