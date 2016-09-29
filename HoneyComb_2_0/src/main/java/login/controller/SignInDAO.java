package login.controller;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class SignInDAO extends SqlSessionDaoSupport {
	
	public List<LogOnDataBean> getMembers(){
		return getSqlSession().selectList("login.getMembers");
	}
	public void insertMember(LogOnDataBean logdb){
		
		logdb.setEmail("email");
		logdb.setPasswd("password");
		logdb.setName("name");
		logdb.setPhone_num("phone_num");
		
		getSqlSession().insert("insertMember",logdb);
	
	}
	
	
	
}
