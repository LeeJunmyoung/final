package promgr.db;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cloud.db.CloudInfo;

public class PromgrDao extends SqlSessionDaoSupport {

	public int getPromgrCount(int com_num, int mem_num) {

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("com_num", com_num);
		map.put("mem_num", mem_num);

		return getSqlSession().selectOne("promgr.count", map);

	}

	public List getPromgrList(int com_num, int mem_num, int startRow, int endRow) {

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

	public String setMem_name(int mem_num) {

		return getSqlSession().selectOne("promgr.set_mem_name", mem_num);

	}

	public CloudInfo setFile_view(int file_num) {

		return getSqlSession().selectOne("promgr.set_file_view", file_num);

	}

	public CommentDataBean setComment_view(int comment_num) {

		return getSqlSession().selectOne("promgr.set_comment_view", comment_num);

	}

	public ChkListViewDataBean setChklist_view(int chkList_num) {

		return getSqlSession().selectOne("promgr.set_chkList_view", chkList_num);

	}

	public List setChkItem(int chkList_num) {

		return getSqlSession().selectList("promgr.set_chkItem", chkList_num);

	}

	public int addPromgr(PromgrDataBean article) {

		return getSqlSession().insert("promgr.add_promgr", article);

	}

	public int delchkItem(String promgr_num) {

		return getSqlSession().delete("promgr.del_chkItem", promgr_num);

	}

	public int delchkList(String promgr_num) {

		return getSqlSession().delete("promgr.del_chkList", promgr_num);

	}
	
	public int delFile(String promgr_num) {

		return getSqlSession().delete("promgr.del_file", promgr_num);

	}

	public int delComment(String promgr_num, int com_num) {

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("promgr_num", promgr_num);
		map.put("com_num", com_num);

		return getSqlSession().delete("promgr.del_comment", map);

	}

	public int delPromgr(String promgr_num, int com_num) {

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("promgr_num", promgr_num);
		map.put("com_num", com_num);

		return getSqlSession().delete("promgr.del_promgr", map);

	}

} // public class NoticeDao end
