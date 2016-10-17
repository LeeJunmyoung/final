package salary.db;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class SalaryDao extends SqlSessionDaoSupport {

	public List<DeptDataBean> getDeptList(int com_num) {
		return getSqlSession().selectList("salary.getDept", com_num);
	}

	public List<PosDataBean> getPosList(int com_num) {
		return getSqlSession().selectList("salary.getPos", com_num);
	}

	public List<SalaryDataBean> getSalaryList(int com_num, int dept_num, int pos_num) {

		List<SalaryDataBean> list = null;

		if (dept_num > -1) {

			HashMap<String, Integer> map = new HashMap<String, Integer>();

			map.put("com_num", com_num);
			map.put("dept_num", dept_num);

			list = getSqlSession().selectList("salary.getSalary_list_dept", map);

		} else if (pos_num > -1) {

			HashMap<String, Integer> map = new HashMap<String, Integer>();

			map.put("com_num", com_num);
			map.put("pos_num", pos_num);

			list = getSqlSession().selectList("salary.getSalary_list_pos", map);

		} else {

			list = getSqlSession().selectList("salary.getSalary_list_all", com_num);

		}

		return list;

	}

	public SalaryDataBean getSalary(int mem_num) {

		return getSqlSession().selectOne("salary.getSalary_item", mem_num);

	}

	public int modSalary(SalaryDataBean article) {
		return getSqlSession().update("salary.setSalary_item", article);
	}

} // public class NoticeDao end
