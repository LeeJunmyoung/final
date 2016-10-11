package mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mypage.db.ResumeDAO;

@Controller
public class Resume_Controller {
	
	private ResumeDAO dao;

	public void setDao(ResumeDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/my_resume")
	public ModelAndView my_Resume(HttpServletRequest request) {
		// mypage 이력서 조회
		
		int mem_num = (int) request.getSession().getAttribute("mem_num");
		
		List base_list = dao.base_Data(mem_num);
		List school_list = dao.school_Data(mem_num);
		List edu_list = dao.edu_Data(mem_num);
		List certi_list = dao.certi_Data(mem_num);
		List mili_list = dao.mili_Data(mem_num);
		List career_list = dao.career_Data(mem_num);
		
		ModelAndView mav = new ModelAndView("resume_change");
		
		mav.addObject("base_list", base_list);
		mav.addObject("school_list", school_list);
		mav.addObject("edu_list", edu_list);
		mav.addObject("certi_list", certi_list);
		mav.addObject("mili_list", mili_list);
		mav.addObject("career_list", career_list);
		
		return mav;
	}
	
	@RequestMapping("/certi_search")
	public ModelAndView certi_Search() {
		
		ModelAndView mav = new ModelAndView("resume_certi_search");
		
		return mav;
	}

}
