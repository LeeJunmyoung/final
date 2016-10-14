package accept.db;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import salary.db.SalaryDataBean;

public class AcceptDAO extends SqlSessionDaoSupport {

	public List accept_List(int num) {
		// 신청자 List

		int com_num = -num;
		List awaiter_list = getSqlSession().selectList("accept.accept_select", com_num);

		for (int i = 0; i < awaiter_list.size(); i++) {
			System.out.println(awaiter_list.get(i));
		}

		return awaiter_list;
	}

	public int accept_count(int num) {
		// 신청자 총 인원수

		int com_num = -num;
		int count = getSqlSession().selectOne("accept.accept_count", com_num);

		return count;
	}

	public void com_In_Member(int mem_num, int com_num) {
		// 승인

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		map.put("mem_num", mem_num);
		map.put("com_num", com_num);

		int x = getSqlSession().update("accept.com_update_member", map);

		if (x >= 1) {
			System.out.println("member 승인 성공");
		} else {
			System.out.println("member 승인 실패");
		}
	}

	public void com_Out_Member(int mem_num) {
		// 거절

		int x = getSqlSession().delete("accept.com_delete_member", mem_num);

		if (x >= 1) {
			System.out.println("member 거절 성공");
		} else {
			System.out.println("member 거절 실패");
		}
	}

	public void setSalaryMember(int mem_num, int com_num) {

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		map.put("mem_num", mem_num);
		map.put("com_num", com_num);

		int x = getSqlSession().insert("accept.setSalary_member", map);

		if (x > 0) {
			System.out.println("salary member add 성공");
		} else {
			System.out.println("salary member add 실패");
		}

	}

}
