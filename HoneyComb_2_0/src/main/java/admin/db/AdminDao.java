package admin.db;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import admin.controller.Admin_comInsert;
import admin.db.AdminInfo;
import admin.db.AdminNoticeInfo;
import login.controller.LogOnDataBean;

public class AdminDao extends SqlSessionDaoSupport {

	public List<AdminInfo> getadminList(int com_num) {
		List adminlist = new ArrayList<AdminInfo>();
		adminlist = getSqlSession().selectList("getadminlist", com_num);
		return adminlist;
	}

	public List<LogOnDataBean> memadminList(int com_num) {
		List memlist = new ArrayList<LogOnDataBean>();
		memlist = getSqlSession().selectList("memadminlist", com_num);
		return memlist;
	}

	public List<AdminInfo> adminComplete() {
		List completelist = new ArrayList<AdminInfo>();
		completelist = getSqlSession().selectList("admincomplete");
		return completelist;
	}

	public int admincomInsert(int com_num) {
		int admincomInsert = getSqlSession().insert("admincominsert", com_num);
		return admincomInsert;
	}

	public int admincomDelete(int com_num) {
		int admincomDelete = getSqlSession().delete("admincomdelete", com_num);
		return admincomDelete;
	}
	
	public int adminUpdate(int com_num) {
		int adminUpdate = getSqlSession().update("adminupdate", com_num);
		return adminUpdate;
	}

	public List<AdminInfo> comadminList(int com_num) {
		List adminlist = new ArrayList<AdminInfo>();
		adminlist = getSqlSession().selectList("comadminlist", com_num);
		return adminlist;
	}

	public int adminNoticeInsert(int notice_admin_num) {
		int adminNoticeInsert = 0;
		adminNoticeInsert = getSqlSession().insert("adminNoticeInsert", notice_admin_num);
		return adminNoticeInsert;
	}

	public List<AdminNoticeInfo> getadminNotice(int notice_admin_num) {
		List adminNotice = new ArrayList<AdminNoticeInfo>();
		adminNotice = getSqlSession().selectList("getadminNotice", notice_admin_num);
		return adminNotice;
	}
}
