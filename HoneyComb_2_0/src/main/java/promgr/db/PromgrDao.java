package promgr.db;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cloud.db.CloudInfo;

public class PromgrDao extends SqlSessionDaoSupport {

	public int getPromgrCount(int com_num, int mem_num) {

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("com_num", com_num);
		map.put("mem_num", mem_num);

		return getSqlSession().selectOne("promgr.count", map);

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

	public int addPromgr(PromgrDataBean article) {

		return getSqlSession().insert("promgr.add_promgr", article);

	}

	public int delPromgr(String promgr_num, int com_num) {

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("promgr_num", promgr_num);
		map.put("com_num", com_num);

		getSqlSession().delete("promgr.del_chkItem_all", promgr_num);

		getSqlSession().delete("promgr.del_chkList_all", promgr_num);

		getSqlSession().delete("promgr.del_file_all", promgr_num);

		getSqlSession().delete("promgr.del_comment_all", map);

		return getSqlSession().delete("promgr.del_promgr", map);

	}

	public int addComment(CommentDataBean article) {

		getSqlSession().insert("promgr.add_comment", article);

		int mem_num = article.getMem_num();
		String new_comment_num = getSqlSession().selectOne("promgr.new_comment_num", mem_num);

		int promgr_num = article.getPromgr_num();
		String old_comment_num = getSqlSession().selectOne("promgr.get_comment_num", promgr_num);

		String comment_num_str = "";

		if (old_comment_num == null) {
			comment_num_str = new_comment_num;
		} else {
			comment_num_str = old_comment_num + "/" + new_comment_num;
		}

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("comment_num_str", comment_num_str);
		map.put("promgr_num", promgr_num);

		return getSqlSession().update("promgr.set_comment_num", map);

	}

	public int modComment(int comment_num, String comment_content, Timestamp update_time) {

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("comment_num", comment_num);
		map.put("comment_content", comment_content);
		map.put("update_time", update_time);

		return getSqlSession().update("promgr.mod_comment", map);

	}

	public int delComment(int comment_num, int promgr_num) {

		getSqlSession().delete("promgr.del_comment_item", comment_num);

		List<String> all_comment_num = getSqlSession().selectList("promgr.get_comment_num_all", promgr_num);

		String comment_num_str = "";

		for (int i = 0; i < all_comment_num.size(); i++) {

			if (comment_num_str.equals("")) {
				comment_num_str += all_comment_num.get(i);
			} else {
				comment_num_str += "/" + all_comment_num.get(i);
			}

		}

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("comment_num_str", comment_num_str);
		map.put("promgr_num", promgr_num);

		return getSqlSession().update("promgr.set_comment_num", map);

	}

} // public class NoticeDao end
