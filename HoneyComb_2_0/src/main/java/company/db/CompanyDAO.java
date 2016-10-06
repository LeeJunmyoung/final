package company.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class CompanyDAO extends SqlSessionDaoSupport {

	public int temp_Insert(TempComDTO dto) {
		// temp_com 등록

		int x = getSqlSession().insert("company.temp_com_insert", dto);
		
		if (x >= 1) {
			System.out.println("temp_com 등록 성공");
		} else {
			System.out.println("temp_com 등록 실패");
		}

		return x;
	}

	public int temp_ceo_Update(String com_name, int mem_num) {
		// ceo 등록

		Map map = new HashMap<>();

		map.put("com_name", com_name);
		map.put("mem_num", mem_num);

		int x = getSqlSession().update("company.temp_com_ceo", map);

		if (x >= 1) {
			System.out.println("ceo 등록 성공");
		} else {
			System.out.println("ceo 등록 실패");
		}
		
		return x;
	}
	
	public int mem_ComData_Update(MembersDTO dto) {
		
		int x = getSqlSession().update("company.temp_mem_update", dto);
		
		if (x >= 1) {
			System.out.println("members Company 등록 성공");
		} else {
			System.out.println("members Company 등록 실패");
		}
		
		return x;
	}
	
	public List searchCom(String com_name) {
		
		List search_list = new ArrayList<>();
		
		search_list = getSqlSession().selectList("company.complete_com_search", "%"+com_name+"%");
		
		return search_list;
	}

}
