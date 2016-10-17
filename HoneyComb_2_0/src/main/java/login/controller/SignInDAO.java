package login.controller;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class SignInDAO extends SqlSessionDaoSupport {
	
	public List<LogOnDataBean> getMembers(){
		return getSqlSession().selectList("login.getMembers");
	}
	public void insertMember(LogOnDataBean logdb){
		logdb.setPhone_num(logdb.getPnum1()+logdb.getPnum2()+logdb.getPnum3());
		getSqlSession().insert("login.insertMember",logdb);
	
	}
	public String CheckEmail(String email) {
		 //이메일 select count로 개수 받아옴(0이면 중복x, 1> 중복)
	String mailCheck = getSqlSession().selectOne("login.mailCheck", email);
		return mailCheck;
	}
	
	public void insertAPI(String email, String name, String gender){
		LogOnDataBean logdb = new LogOnDataBean();
		logdb.setEmail(email);
		logdb.setName(name);
		logdb.setGender(gender);
		getSqlSession().insert("login.insertInfo",logdb);
		
	}
	
}
