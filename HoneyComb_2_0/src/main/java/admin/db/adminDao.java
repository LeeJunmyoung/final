package admin.db;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import admin.db.adminInfo;

public class adminDao extends SqlSessionDaoSupport {

	public List<adminInfo> getadminList(int com_num) {
		List adminlist = new ArrayList<adminInfo>();
		adminlist = getSqlSession().selectList("admin.getadminlist", com_num);

		return adminlist;

	}
}
