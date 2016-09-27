package login.controller;

import java.util.ArrayList;

public interface SignInMapper {
	
	ArrayList<LogOnDataBean> getMembers();

	void insertMember(LogOnDataBean logondb);
}
