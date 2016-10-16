package mypage.db;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import dept.db.Mem_Career;
import dept.db.Mem_Certi;
import dept.db.Mem_Edu;
import dept.db.Mem_Mili;
import dept.db.Mem_School;

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
	
	public void school_Insert(int mem_num, Mem_School sch) {
		
		sch.setMem_num(mem_num);
		
		int x = getSqlSession().insert("mypage.school_insert", sch);
		
		if(x >= 1) {
			System.out.println("school insert 성공");
		} else if(x <= 0){
			System.out.println("school insert 실패");
		}
		
	}
	
	public void edu_Insert(int mem_num, Mem_Edu edu) {
		
		edu.setMem_num(mem_num);
		
		int x = getSqlSession().insert("mypage.edu_insert", edu);
		
		if(x >= 1) {
			System.out.println("edu insert 성공");
		} else if(x <= 0){
			System.out.println("edu insert 실패");
		}
		
	}
	
	public void certi_Insert(int mem_num, Mem_Certi cer) {
		
		cer.setMem_num(mem_num);
		
		int x = getSqlSession().insert("mypage.certi_insert", cer);
		
		if(x >= 1) {
			System.out.println("certi insert 성공");
		} else if(x <= 0){
			System.out.println("certi insert 실패");
		}
		
	}
	
	public void mili_Insert(int mem_num, Mem_Mili mil) {
		
		mil.setMem_num(mem_num);
		
		int x = getSqlSession().insert("mypage.mili_insert", mil);
		
		if(x >= 1) {
			System.out.println("mili insert 성공");
		} else if(x <= 0){
			System.out.println("mili insert 실패");
		}
		
	}
	
	public void career_Insert(int mem_num, Mem_Career car) {
		
		car.setMem_num(mem_num);
		
		int x = getSqlSession().insert("mypage.school_insert", car);
		
		if(x >= 1) {
			System.out.println("school insert 성공");
		} else if(x <= 0){
			System.out.println("school insert 실패");
		}
		
	}

}
