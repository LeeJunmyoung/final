package mypage.db;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class ResumeDAO extends SqlSessionDaoSupport {

	public List base_Data(int mem_num) {
		// 이력서 기본정보

		List base_list = getSqlSession().selectList("mypage.base_select", mem_num);

		return base_list;
	}

	public List school_Data(int mem_num) {
		// 학력

		List school_list = getSqlSession().selectList("mypage.school_select", mem_num);

		return school_list;
	}

	public List edu_Data(int mem_num) {
		// 교육이수

		List edu_list = getSqlSession().selectList("mypage.edu_select", mem_num);

		return edu_list;
	}

	public List certi_Data(int mem_num) {
		// 자격증

		List certi_list = getSqlSession().selectList("mypage.certi_select", mem_num);

		return certi_list;
	}

	public List mili_Data(int mem_num) {
		// 병역

		List mili_list = getSqlSession().selectList("mypage.mili_select", mem_num);

		return mili_list;
	}

	public List career_Data(int mem_num) {
		// 경력

		List career_list = getSqlSession().selectList("mypage.career_select", mem_num);

		return career_list;
	}

}
