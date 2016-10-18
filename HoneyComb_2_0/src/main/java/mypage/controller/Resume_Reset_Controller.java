package mypage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mypage.db.ResumeDAO;

@Controller
public class Resume_Reset_Controller {
	
	private ResumeDAO dao;

	public void setDao(ResumeDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("resume_reset")
	public String resume_Pro_View(HttpServletRequest request, @RequestParam int code) {

		int mem_num = (int) request.getSession().getAttribute("mem_num");

		if (code == 1) { // 학력

			dao.school_Reset(mem_num);

		} else if (code == 2) { // 교육이수

			dao.edu_Reset(mem_num);

		} else if (code == 3) { // 자격증

			dao.certi_Reset(mem_num);

		} else if (code == 4) { // 병역

			dao.mili_Reset(mem_num);

		} else if (code == 5) { // 경력

			dao.career_Reset(mem_num);

		}

		return "resume_reset_close";

	}

}
