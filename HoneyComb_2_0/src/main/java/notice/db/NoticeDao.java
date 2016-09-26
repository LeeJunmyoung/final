package notice.db;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class NoticeDao extends SqlSessionDaoSupport {

	public int getNoticeCount(int com_num) {

		return getSqlSession().selectOne("notice.count", com_num);

	}

	public List getNoticeItem(int com_num, int startRow, int endRow) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		
		if (startRow == -1) {
			
			map.put("com_num", com_num);
			map.put("endRow", endRow);

			return getSqlSession().selectList("notice.item_main", map);

		} else {
			
			map.put("com_num", com_num);
			map.put("startRow", startRow);
			map.put("endRow", endRow);
			
			return getSqlSession().selectList("notice.item_all", com_num);

		}

	}

} // public class NoticeDao end
