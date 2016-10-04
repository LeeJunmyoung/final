package main.db;

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

		HashMap<String, Object> map = new HashMap<String, Object>();

		if (startRow == -1) {

			map.put("com_num", com_num);
			map.put("endRow", endRow);

			return getSqlSession().selectList("notice.list_main", map);

		} else {

			map.put("com_num", com_num);
			map.put("startRow", startRow);
			map.put("endRow", endRow);

			return getSqlSession().selectList("notice.list_all", com_num);

		}

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
		map.put("mem_num", "%"+mem_num+"%");

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

	public List<PromgrDataBean> setView(List<PromgrDataBean> articleList) {

		int[] num_arr = null;

		for (int i = 0; i < articleList.size(); i++) {

			PromgrDataBean article = (PromgrDataBean) articleList.get(i);

			// mem_name_arr
			num_arr = cut_num(article.getMem_num());

			article.setMem_name_arr(setMem_name(num_arr));

			// chklist_view
			if (article.getChklist_title_num() != null) {
				num_arr = cut_num(article.getChklist_title_num());
			}

			article.setChklist_view(setChklist(num_arr));

			// file_view
			if (article.getFile_num() != null) {
				num_arr = cut_num(article.getFile_num());
			}

			article.setFile_view(setFile(num_arr));

			// comment_view
			if (article.getComment_num() != null) {
				num_arr = cut_num(article.getComment_num());
			}

			article.setComment_view(setComment(num_arr));

		}

		return articleList;

	}

	private int[] cut_num(String num) {

		int[] arr = null;
		int idx = 0;

		StringTokenizer stz = new StringTokenizer(num, "/");

		arr = new int[stz.countTokens()];

		while (stz.hasMoreTokens()) {
			arr[idx] = Integer.parseInt(stz.nextToken());
			idx++;
		} // while (stz.hasMoreTokens()) end

		return arr;

	}

	private String[] setMem_name(int[] num_arr) {

		String[] mem_name_arr = new String[num_arr.length];

		for (int j = 0; j < num_arr.length; j++) {

			int mem_num = num_arr[j];
			String mem_name = getSqlSession().selectOne("promgr.set_mem_name", mem_num);
			mem_name_arr[j] = mem_name;

		}

		return mem_name_arr;
	}

	private List<ChkListViewDataBean> setChklist(int[] num_arr) {

		List<ChkListViewDataBean> chkList_view = new ArrayList<ChkListViewDataBean>();

		for (int j = 0; j < num_arr.length; j++) {

			int chkList_num = num_arr[j];
			ChkListViewDataBean chkList = getSqlSession().selectOne("promgr.set_chkList_view", chkList_num);

			List<ChkItemDataBean> chkItem = getSqlSession().selectList("promgr.set_chkItem", chkList_num);

			chkList.setItem_bean(chkItem);

			chkList_view.add(chkList);

		}

		return chkList_view;

	}

	private List<CloudInfo> setFile(int[] num_arr) {

		List<CloudInfo> file_view = new ArrayList<CloudInfo>();

		for (int j = 0; j < num_arr.length; j++) {

			int file_num = num_arr[j];
			CloudInfo file = getSqlSession().selectOne("promgr.set_file_view", file_num);
			file_view.add(file);

		}

		return file_view;

	}

	private List<CommentDataBean> setComment(int[] num_arr) {

		List<CommentDataBean> comment_view = new ArrayList<CommentDataBean>();

		for (int j = 0; j < num_arr.length; j++) {

			int comment_num = num_arr[j];
			CommentDataBean comment = getSqlSession().selectOne("promgr.set_comment_view", comment_num);
			comment_view.add(comment);

		}

		return comment_view;

	}
	
	public List viewCal(int mem_num){
		
		List totalCal = new ArrayList<>();
		totalCal = getSqlSession().selectList("cal.viewCal",mem_num);
		
		for(Object c : totalCal){
			Cal_DataBean cal = (Cal_DataBean) c;
			System.out.println(cal.toString());
			
		}
		
		
		
		return totalCal;
		
		
		
		
	}
	
	
	
	
	
	

}
