package salary.db;

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

		if (dept_num > -1) {

		} else if (pos_num > -1) {

		} else {
			
		}

		return null;
	}

	public SalaryDataBean getSalary(int mem_num) {
		
		return null;
		
	}

} // public class NoticeDao end
