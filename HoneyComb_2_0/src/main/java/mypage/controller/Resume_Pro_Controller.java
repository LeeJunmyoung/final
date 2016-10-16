package mypage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dept.db.Mem_Career;
import dept.db.Mem_Certi;
import dept.db.Mem_Edu;
import dept.db.Mem_Mili;
import dept.db.Mem_School;
import mypage.db.ResumeDAO;

@Controller
public class Resume_Pro_Controller {

	private ResumeDAO dao;

	public void setDao(ResumeDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("resume_pro")
	public ModelAndView resume_Pro_View(HttpServletRequest request, @RequestParam int code) {

		int mem_num = (int) request.getSession().getAttribute("mem_num");
		ModelAndView mav = new ModelAndView("resume_submit_form");

		if (code == 1) { // 학력

			mav.addObject("code", 1);

		} else if (code == 2) { // 교육이수

			mav.addObject("code", 2);

		} else if (code == 3) { // 자격증

			mav.addObject("code", 3);

		} else if (code == 4) { // 병역

			mav.addObject("code", 4);

		} else if (code == 5) { // 경력

			mav.addObject("code", 5);

		}

		return mav;

	}

	@RequestMapping("school_pro")
	public String school_Pro(HttpServletRequest request, @RequestParam Mem_School sch) {

		int mem_num = (int) request.getSession().getAttribute("mem_num");
		
		dao.school_Insert(mem_num, sch);

		return "resume_close";
	}

	@RequestMapping("edu_pro")
	public String edu_Pro(HttpServletRequest request, @RequestParam Mem_Edu edu) {

		int mem_num = (int) request.getSession().getAttribute("mem_num");
		
		dao.edu_Insert(mem_num, edu);

		return "resume_close";
	}

	@RequestMapping("certi_pro")
	public String certi_Pro(HttpServletRequest request, @RequestParam Mem_Certi cer) {

		int mem_num = (int) request.getSession().getAttribute("mem_num");
		
		dao.certi_Insert(mem_num, cer);

		return "resume_close";
	}

	@RequestMapping("mili_pro")
	public String mili_Pro(HttpServletRequest request, @RequestParam Mem_Mili mil) {

		int mem_num = (int) request.getSession().getAttribute("mem_num");
		
		dao.mili_Insert(mem_num, mil);

		return "resume_close";
	}

	@RequestMapping("career_pro")
	public String career_Pro(HttpServletRequest request, @RequestParam Mem_Career car) {

		int mem_num = (int) request.getSession().getAttribute("mem_num");
		
		dao.career_Insert(mem_num, car);

		return "resume_close";
	}

}
