package notice.db;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class NoticeDao extends SqlSessionDaoSupport {

	public int getNoticeCount(int com_num) {

		return getSqlSession().selectOne("notice.count_notice", com_num);

	}

	public List<NoticeDataBean> getNoticeList(int com_num, int startRow, int endRow) {

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("com_num", com_num);
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<NoticeDataBean> articleList = getSqlSession().selectList("notice.list_all", map);

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

	public int addNotice(NoticeDataBean article) {

		return getSqlSession().insert("notice.add", article);

	}

} // public class NoticeDao end
