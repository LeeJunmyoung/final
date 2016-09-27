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

/*	public List setChklist(int mem_num) {

		return getSqlSession().selectOne("promgr.set_mem_name", mem_num);

	}*/
	
	public CloudInfo setFile_view(int file_num) {

		return getSqlSession().selectOne("promgr.set_file_view", file_num);

	}
	
	public CommentDataBean setComment_view(int comment_num) {

		return getSqlSession().selectOne("promgr.set_comment_view", comment_num);

	}
	
	/*
	 * public int insertItem(NoticeDataBean article) {
	 * 
	 * return getSqlSession().insert("notice.item_add", article);
	 * 
	 * }
	 */

} // public class NoticeDao end
