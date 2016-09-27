package admin.db;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import admin.db.adminInfo;

public class adminDao extends SqlSessionDaoSupport {

	public List<adminInfo> getadminList(int com_num) {
		List adminlist = new ArrayList<adminInfo>();
		adminlist = getSqlSession().selectList("getadminlist", com_num);
		System.out.println(adminlist);
		return adminlist;

	}
}
