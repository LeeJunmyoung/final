package login.controller;

import java.util.ArrayList;

public interface SignInDAO {
	 public ArrayList<LogOnDataBean> getMembers();
	 public void insertMember(LogOnDataBean logondb);
}
