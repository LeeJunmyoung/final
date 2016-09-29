package admin.db;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import admin.controller.Admin_comInsert;
import admin.db.AdminInfo;
import login.controller.LogOnDataBean;

public class AdminDao extends SqlSessionDaoSupport {

	public List<AdminInfo> getadminList(int com_num) {
		List adminlist = new ArrayList<AdminInfo>();
		adminlist = getSqlSession().selectList("getadminlist", com_num);
		return adminlist;
	}
	
	public List<LogOnDataBean> memadminList(int com_num){
		List memlist = new ArrayList<LogOnDataBean>();
		memlist = getSqlSession().selectList("memadminlist",com_num);
		return memlist;
	}
	
	public List<AdminInfo> adminComplete(int com_num){
		List completelist = new ArrayList<AdminInfo>();
		completelist = getSqlSession().selectList("admincomplete", com_num);
		return completelist;
	}
	
	public int admincomInsert(int com_num){
		int admincomInsert = 0;
		admincomInsert = getSqlSession().insert("admincominsert", com_num);
		return admincomInsert;
	}
	
	public int admincomDelete(int com_num){
		int admincomDelete = 0;
		admincomDelete = getSqlSession().insert("admincomdelete", com_num);
		return admincomDelete;
	}
}
