package admin.db;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import admin.db.adminInfo;

public class adminDao extends SqlSessionDaoSupport {

	public List<adminInfo> getadminList(int com_num) {
		System.out.println("getadminList실행중");
		List adminlist = new ArrayList<adminInfo>();
		System.out.println(adminlist);
		System.out.println("getadminList중간");
		adminlist = getSqlSession().selectList("getadminlist", com_num);
		System.out.println(adminlist);
		System.out.println("getadminList마지막");

		return adminlist;

	}
}
