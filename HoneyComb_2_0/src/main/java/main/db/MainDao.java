package main.db;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cal.db.Cal_DataBean;
import cloud.db.CloudInfo;
import promgr.db.ChkItemDataBean;
import promgr.db.ChkListViewDataBean;
import promgr.db.CommentDataBean;
import promgr.db.PromgrDataBean;

public class MainDao extends SqlSessionDaoSupport {

	// notice
	public int getNoticeCount(int com_num) {

		return getSqlSession().selectOne("notice.count_notice", com_num);

	}

	public List<NoticeDataBean> getNoticeList(int com_num, int startRow, int endRow) {

		List<NoticeDataBean> articleList = null;

		if (startRow == -1) {

			HashMap<String, Object> map = new HashMap<String, Object>();

			map.put("com_num", com_num);
			map.put("endRow", endRow);

			articleList = getSqlSession().selectList("notice.list_main", map);

		} else {

			HashMap<String, Object> map = new HashMap<String, Object>();

			map.put("com_num", com_num);
			map.put("startRow", startRow);
			map.put("endRow", endRow);

			articleList = getSqlSession().selectList("notice.list_all", com_num);

		}

		for (int i = 0; i < articleList.size(); i++) {

			NoticeDataBean article = (NoticeDataBean) articleList.get(i);
			int isNew = setIsNew(article.getNotice_num());
			article.setIsNew(isNew);

		}

		return articleList;

	}

	public int setIsNew(int notice_num) {

		int ingDay = getSqlSession().selectOne("notice.set_isNew", notice_num);

		if (ingDay < 1) {
			return 0;
		} else {
			return -1;
		}

	}

	// promgr
	public int getPromgrCount(int com_num, int mem_num) {

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("com_num", com_num);
		map.put("mem_num", "%" + mem_num + "%");

		return getSqlSession().selectOne("promgr.count_promgr", map);

	}

	public List<PromgrDataBean> getPromgrList(int com_num, int mem_num, int startRow, int endRow) {

		HashMap<String, Object> map = new HashMap<String, Object>();

		if (startRow == -1) {

			map.put("com_num", com_num);
			map.put("mem_num", mem_num);
			map.put("endRow", endRow);

			return getSqlSession().selectList("promgr.list_main", map);

		} else {

			map.put("com_num", com_num);
			map.put("mem_num", mem_num);
			map.put("startRow", startRow);
			map.put("endRow", endRow);

			return getSqlSession().selectList("promgr.list_all", com_num);

		}

	}

	public List viewCal(int mem_num) {

		List totalCal = new ArrayList<>();
		List totalCal1 = new ArrayList<>();
		
		totalCal = getSqlSession().selectList("cal.viewCal", mem_num);
		
		for (Object c : totalCal) {
			Cal_DataBean cal = (Cal_DataBean) c;
			
			Date formatdate = new Date(cal.getCal_end().getYear(),cal.getCal_end().getMonth(),cal.getCal_end().getDate()+1);
			
			
			cal.setCal_end(formatdate);
			formatdate= new Date(cal.getCal_start().getYear(),cal.getCal_start().getMonth(),cal.getCal_start().getDate());
			cal.setCal_start(formatdate);
			//System.out.println(cal.toString());
			

			totalCal1.add(cal);
		}

		return totalCal1;

	}

}
