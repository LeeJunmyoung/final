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
		map.put("mem_num", "%" + mem_num + "%");

		return getSqlSession().selectOne("promgr.count_promgr", map);

	}

	public List<PromgrDataBean> getPromgrList(int com_num, int mem_num, int startRow, int endRow) {

		if (startRow == -1) {

			HashMap<String, Object> map = new HashMap<String, Object>();

			map.put("com_num", com_num);
			map.put("mem_num", "%" + mem_num + "%");
			map.put("endRow", endRow);

			return getSqlSession().selectList("promgr.list_main", map);

		} else {

			HashMap<String, Object> map = new HashMap<String, Object>();

			map.put("com_num", com_num);
			map.put("mem_num", "%" + mem_num + "%");
			map.put("startRow", startRow);
			map.put("endRow", endRow);

			return getSqlSession().selectList("promgr.list_all", map);

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
			String mem_name = getSqlSession().selectOne("promgr.get_mem_name", mem_num);
			mem_name_arr[j] = mem_name;

		}

		return mem_name_arr;
	}

	private List<ChkListViewDataBean> setChklist(int[] num_arr) {

		List<ChkListViewDataBean> chkList_view = new ArrayList<ChkListViewDataBean>();
		List<ChkItemDataBean> chkItem = new ArrayList<ChkItemDataBean>();		
		
		for (int j = 0; j < num_arr.length; j++) {

			int chkList_num = num_arr[j];

			ChkListViewDataBean chkList = getSqlSession().selectOne("promgr.get_chkList_view", chkList_num);

			chkItem = getSqlSession().selectList("promgr.get_chkItem", chkList_num);

			if (chkList != null) {
				chkList.setItem_bean(chkItem);
			}

			chkList_view.add(chkList);

		}

		return chkList_view;

	}

	private List<CloudInfo> setFile(int[] num_arr) {

		List<CloudInfo> file_view = new ArrayList<CloudInfo>();

		for (int j = 0; j < num_arr.length; j++) {

			int file_num = num_arr[j];
			CloudInfo file = getSqlSession().selectOne("promgr.get_file_view", file_num);
			file_view.add(file);

		}

		return file_view;

	}

	private List<CommentDataBean> setComment(int[] num_arr) {

		List<CommentDataBean> comment_view = new ArrayList<CommentDataBean>();

		for (int j = 0; j < num_arr.length; j++) {

			int comment_num = num_arr[j];
			CommentDataBean comment = getSqlSession().selectOne("promgr.get_comment_view", comment_num);
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

		PromgrDataBean promgr = getSqlSession().selectOne("promgr.get_promgr", promgr_num);

		String old_comment_num = promgr.getComment_num();

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

	public List<MemberListDataBean> getMemberJoinList(String promgr_num, int mem_num) {
		// select * from promgr where promgr_num=?

		PromgrDataBean promgr = getSqlSession().selectOne("promgr.get_promgr", promgr_num);

		int[] num_arr = cut_num(promgr.getMem_num());

		List<MemberListDataBean> articleList = new ArrayList<MemberListDataBean>();

		for (int i = 0; i < num_arr.length; i++) {

			if (mem_num != num_arr[i]) {

				MemberListDataBean article = getSqlSession().selectOne("promgr.get_member_join", num_arr[i]);

				articleList.add(article);

			}

		}

		return articleList;

	}

	public List<MemberListDataBean> getMemberSearchList(String promgr_num) {

		PromgrDataBean promgr = getSqlSession().selectOne("promgr.get_promgr", promgr_num);

		int com_num = promgr.getCom_num();
		int[] mem_num_arr = cut_num(promgr.getMem_num());

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("com_num", com_num);
		map.put("mem_num_arr", mem_num_arr);

		return getSqlSession().selectList("promgr.get_member_search", map);

	}

	public int addMembers(String promgr_num, String[] add_mem_num) {

		String mem_num_str = "";
		for (int i = 0; i < add_mem_num.length; i++) {
			mem_num_str += "/" + add_mem_num[i];
		}

		PromgrDataBean promgr = getSqlSession().selectOne("promgr.get_promgr", promgr_num);

		String new_mem_num = promgr.getMem_num() + mem_num_str;

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("promgr_num", promgr_num);
		map.put("new_mem_num", new_mem_num);

		return getSqlSession().update("promgr.set_mem_num", map);

	}

	public int delMembers(String promgr_num, String[] del_mem_num) {

		PromgrDataBean promgr = getSqlSession().selectOne("promgr.get_promgr", promgr_num);

		int[] num_arr = cut_num(promgr.getMem_num());

		String new_mem_num = "";

		for (int i = 0; i < del_mem_num.length; i++) {

			for (int j = 0; j < num_arr.length; j++) {

				if (!del_mem_num[i].equals(String.valueOf(num_arr[j]))) {

					if (j == 0) {
						new_mem_num += num_arr[j];
					} else {
						new_mem_num += "/" + num_arr[j];
					}

				}

			}

		}

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("promgr_num", promgr_num);
		map.put("new_mem_num", new_mem_num);

		return getSqlSession().update("promgr.set_mem_num", map);

	}

	public int addChkList(ChkListDataBean article) {

		getSqlSession().insert("promgr.add_chkList", article);

		String chkList_name = article.getChklist_title_name();
		String new_chkList_num = getSqlSession().selectOne("promgr.new_chkList_num", chkList_name);

		String promgr_num = article.getPromgr_num();
		PromgrDataBean promgr = getSqlSession().selectOne("promgr.get_promgr", promgr_num);

		String old_chklist_title_num = promgr.getChklist_title_num();

		String chkList_num_str = "";

		if (old_chklist_title_num == null) {
			chkList_num_str = new_chkList_num;
		} else {
			chkList_num_str = old_chklist_title_num + "/" + new_chkList_num;
		}

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("chkList_num_str", chkList_num_str);
		map.put("promgr_num", promgr_num);

		return getSqlSession().update("promgr.set_chkList_num", map);

	}

	public int modChkList(int list_num, String list_name) {

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("list_num", list_num);
		map.put("list_name", list_name);

		return getSqlSession().update("promgr.mod_chkList", map);

	}

	public int delChkList(String promgr_num, int list_num) {

		delChkItem(promgr_num, list_num, 0);

		getSqlSession().delete("promgr.del_chkList", list_num);

		List<String> all_chkList_num = getSqlSession().selectList("promgr.get_chkList_num_all", promgr_num);

		String chkList_num_str = "";

		for (int i = 0; i < all_chkList_num.size(); i++) {

			if (chkList_num_str.equals("")) {
				chkList_num_str += all_chkList_num.get(i);
			} else {
				chkList_num_str += "/" + all_chkList_num.get(i);
			}

		}

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("promgr_num", promgr_num);
		map.put("chkList_num_str", chkList_num_str);

		return getSqlSession().update("promgr.set_chkList_num", map);

	}

	private int promgrIng(String promgr_num) {

		int promgr_chkItem_all = getSqlSession().selectOne("promgr.count_promgr_chkItem_all", promgr_num);
		int promgr_chkItem_chk = getSqlSession().selectOne("promgr.count_promgr_chkItem_chk", promgr_num);

		int promgr_ing = (int) ((double) promgr_chkItem_chk / (double) promgr_chkItem_all * 100);

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("promgr_num", promgr_num);
		map.put("promgr_ing", promgr_ing);

		return getSqlSession().update("promgr.set_promgr_ing", map);

	}

	public int addChkItem(ChkItemDataBean article) {

		getSqlSession().insert("promgr.add_chkItem", article);

		String chkItem_name = article.getChklist_item_name();
		String new_chkItem_num = getSqlSession().selectList("promgr.new_chkItem_num", chkItem_name).get(0).toString();

		String promgr_num = String.valueOf(article.getPromgr_num());
		PromgrDataBean promgr = getSqlSession().selectOne("promgr.get_promgr", promgr_num);

		String old_chklist_item_num = promgr.getChklist_item_num();

		String chkItem_num_str = "";

		if (old_chklist_item_num == null) {
			chkItem_num_str = new_chkItem_num;
		} else {
			chkItem_num_str = old_chklist_item_num + "/" + new_chkItem_num;
		}

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("chkItem_num_str", chkItem_num_str);
		map.put("promgr_num", promgr_num);

		getSqlSession().update("promgr.set_chkItem_num", map);

		chkListIng(article.getChklist_title_num());

		return promgrIng(promgr_num);

	}

	private int chkListIng(int list_num) {

		int list_chkitem_all = getSqlSession().selectOne("promgr.count_list_chkItem_all", list_num);
		int list_chkitem_chk = getSqlSession().selectOne("promgr.count_list_chkItem_chk", list_num);

		int list_ing = (int) ((double) list_chkitem_chk / (double) list_chkitem_all * 100);

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("list_num", list_num);
		map.put("list_ing", list_ing);

		return getSqlSession().update("promgr.set_list_ing", map);

	}

	public int modChkItem(int item_num, String item_name) {

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("item_num", item_num);
		map.put("item_name", item_name);

		return getSqlSession().update("promgr.mod_chkItem", map);

	}

	public int delChkItem(String promgr_num, int list_num, int item_num) {

		if (item_num == 0) {
			getSqlSession().delete("promgr.del_chkItem_list_num", list_num);
		} else {
			getSqlSession().delete("promgr.del_chkItem_item_num", item_num);
		}

		List<String> all_chkItem_num = getSqlSession().selectList("promgr.get_chkItem_num_all", promgr_num);

		String chkItem_num_str = "";

		for (int i = 0; i < all_chkItem_num.size(); i++) {

			if (chkItem_num_str.equals("")) {
				chkItem_num_str += all_chkItem_num.get(i);
			} else {
				chkItem_num_str += "/" + all_chkItem_num.get(i);
			}

		}
		
		chkListIng(list_num);

		promgrIng(promgr_num);

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("promgr_num", promgr_num);
		map.put("chkItem_num_str", chkItem_num_str);

		return getSqlSession().update("promgr.set_chkItem_num", map);

	}

	public int ChangeCheckedItem(String promgr_num, int list_num, int item_num, int checked) {

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("item_num", item_num);
		map.put("checked", checked);

		getSqlSession().update("promgr.set_checked", map);

		chkListIng(list_num);

		return promgrIng(promgr_num);

	}

} // public class NoticeDao end
