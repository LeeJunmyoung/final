package admin.db;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import admin.db.AdminInfo;
import login.controller.LogOnDataBean;

public class AdminDao extends SqlSessionDaoSupport {

	public List<AdminInfo> getadminList(int com_num) {
		List adminlist = new ArrayList<AdminInfo>();
		adminlist = getSqlSession().selectList("getadminlist", com_num);
		System.out.println(adminlist);
		return adminlist;
	}
	
	public List<LogOnDataBean> memadminList(int com_num){
		List memlist = new ArrayList<LogOnDataBean>();
		memlist = getSqlSession().selectList("memadminlist",com_num);
		System.out.println(memlist);
		return memlist;
	}
}
