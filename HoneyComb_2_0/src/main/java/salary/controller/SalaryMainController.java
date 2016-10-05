package salary.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import salary.db.SalaryDao;

@Controller
public class SalaryMainController {

	private SalaryDao dao;

	@Autowired
	public void setDao(SalaryDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/main.do")
	public ModelAndView form(HttpServletRequest request) {
		
		

		ModelAndView mav = new ModelAndView("salary_main");
		// mav.addObject("promgr_count", promgr_count);
		// mav.addObject("articleList", articleList);

		return mav;
	}

}
