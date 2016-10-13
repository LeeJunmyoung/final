package dept.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class DeptDAO extends SqlSessionDaoSupport {

	public Map<Integer, String> dept_Mapping(int com_num) {
		// com_dept_num, com_dept_name 매핑 (조직도)

		ArrayList ddto = (ArrayList) getSqlSession().selectList("dept.select", com_num);
		Map dept_map = new HashMap<Integer, String>();

		for (Object dept : ddto) {
			DeptDTO dto = (DeptDTO) dept;
			dept_map.put(dto.getCom_dept_num(), dto.getCom_dept_name());

		}

		return dept_map;
	}

	public String com_CEO(int com_num) {
		// 회사대표 이름

		String ceo = getSqlSession().selectOne("dept.ceoName", com_num);

		return ceo;
	}

	public List dept_List(int com_num, int com_dept_num) {
		// 부서 내 사원 리스트

		HashMap<String, Object> map = new HashMap<>();
		map.put("com_num", com_num);
		map.put("com_dept_num", com_dept_num);
		List mem_List = getSqlSession().selectList("dept.memList", map);

		return mem_List;
	}

	public List base_Data(int mem_num) {
		// 이력서 기본정보

		List base_list = getSqlSession().selectList("dept.base_select", mem_num);

		return base_list;
	}

	public List school_Data(int mem_num) {
		// 학력

		List school_list = getSqlSession().selectList("dept.school_select", mem_num);

		return school_list;
	}

	public List edu_Data(int mem_num) {
		// 교육이수

		List edu_list = getSqlSession().selectList("dept.edu_select", mem_num);

		return edu_list;
	}

	public List certi_Data(int mem_num) {
		// 자격증

		List certi_list = getSqlSession().selectList("dept.certi_select", mem_num);

		return certi_list;
	}

	public List mili_Data(int mem_num) {
		// 병역

		List mili_list = getSqlSession().selectList("dept.mili_select", mem_num);

		return mili_list;
	}

	public List career_Data(int mem_num) {
		// 경력

		List career_list = getSqlSession().selectList("dept.career_select", mem_num);

		return career_list;
	}

	public void dept_ch(int mem_num, int com_dept_num) {
		// 부서 변경

		String com_dept_name = getSqlSession().selectOne("dept.dept_name_select", com_dept_num);
		
		Map map = new HashMap<>();
		map.put("mem_num", mem_num);
		map.put("com_dept_num", com_dept_num);
		map.put("com_dept_name", com_dept_name);

		int x = getSqlSession().update("dept.dept_ch", map);

	}

	public void pos_ch(int mem_num, int com_pos_num) {
		// 직급 변경

		String com_pos_name = getSqlSession().selectOne("dept.pos_name_select", com_pos_num);
		
		Map map = new HashMap<>();
		map.put("mem_num", mem_num);
		map.put("com_pos_num", com_pos_num);
		map.put("com_pos_name", com_pos_name);

		int x = getSqlSession().update("dept.pos_ch", map);

	}

}
