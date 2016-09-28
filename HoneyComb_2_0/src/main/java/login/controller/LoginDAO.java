package login.controller;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class LoginDAO extends SqlSessionDaoSupport{

	private LogOnDataBean lodb = new LogOnDataBean();
	
	
	
	public LogOnDataBean getLodb() {
		return lodb;
	}


	public LogOnDataBean Checkmembers(String email, String passwd){
		LogOnDataBean lodb = getLodb();
		lodb.setEmail(email);
		lodb.setPasswd(passwd);
		lodb = (LogOnDataBean) getSqlSession().selectOne("login.Checkmembers", lodb);
		return lodb;
	}
	
	
	public String findEmail(String name,String phone_num){
		LogOnDataBean lodb = getLodb();
		String email;
		lodb.setName(name);
		lodb.setPhone_num(phone_num);
		email= (String) getSqlSession().selectOne("login.FindEmail", lodb);
		
		return email;
	}
	
	public String findPasswd(String email){
		String searchEmail="";
		searchEmail= (String) getSqlSession().selectOne("login.FindPasswd",email);
		
		return searchEmail;
	}
	
	public void updatePasswd(String email,String passwd){
		LogOnDataBean lodb = getLodb();
		lodb.setEmail(email);
		lodb.setPasswd(passwd);
		
		
		getSqlSession().update("login.UpdatePasswd", lodb);
	}
	
	public LogOnDataBean getUserInfo(String email){
		
		LogOnDataBean lodb = getLodb();
	
		lodb = (LogOnDataBean) getSqlSession().selectOne("login.getUserInfo", email);
	

		
		
		return lodb;
	}
	
	
	
	
	
}
