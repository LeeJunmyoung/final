package mypage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("")
	public String school_Pro() {

		return "";
	}

	@RequestMapping("")
	public String edu_Pro() {

		return "";
	}

	@RequestMapping("")
	public String certi_Pro() {

		return "";
	}

	@RequestMapping("")
	public String mili_Pro() {

		return "";
	}

	@RequestMapping("")
	public String career_Pro() {

		return "";
	}

}
