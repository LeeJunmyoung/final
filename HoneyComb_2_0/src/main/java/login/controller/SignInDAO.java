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
	public String CheckEmail(String email) {
		 
	String mailCheck = getSqlSession().selectOne("mailCheck", email);
		
		return mailCheck;
	}
	
	
	
}
