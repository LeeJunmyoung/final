package mypage.db;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MyPageDAO extends SqlSessionDaoSupport {
	
	public void passwd_Change(int mem_num, String passwd) {
		// 비밀번호 바꾸기
		
		Map map = new HashMap<>();
		
		map.put("mem_num", mem_num);
		map.put("passwd", passwd);

		int x = getSqlSession().update("mypage.passwd_change", map);

		if (x >= 1) {
			System.out.println("password change 성공");
		} else {
			System.out.println("password change 실패");
		}
	}
	
	public void profile_Change(int mem_num, String profile_img) {
		
		Map map = new HashMap<>();
		
		map.put("mem_num", mem_num);
		map.put("profile_img", profile_img);
		
		int x = getSqlSession().update("mypage.profile_change", map);
		
		if (x >= 1) {
			System.out.println("profile_img change 성공");
		} else {
			System.out.println("profile_img change 실패");
		}
	}
	
	public void account_Delete(int mem_num) {
		// 계정 탈퇴
		
	}

}
