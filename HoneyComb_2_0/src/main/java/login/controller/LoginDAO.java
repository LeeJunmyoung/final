package login.controller;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class LoginDAO extends SqlSessionDaoSupport{

	public LogOnDataBean Checkmembers(String email, String passwd){
		LogOnDataBean lodb = new LogOnDataBean();
		lodb.setEmail(email);
		lodb.setPasswd(passwd);
		lodb = (LogOnDataBean) getSqlSession().selectOne("login.Checkmembers", lodb);
		
		
		return lodb;
	}
	
	
}
