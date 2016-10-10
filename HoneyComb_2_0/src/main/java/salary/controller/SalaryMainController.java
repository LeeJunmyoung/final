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

	@RequestMapping("/user_main.do")
	public ModelAndView user_form(HttpServletRequest request) {

		int mem_num = (int) request.getSession().getAttribute("mem_num");

//		int salary = dao.getSalary(mem_num);

		ModelAndView mav = new ModelAndView("salary_user_main");
//		mav.addObject("salary", salary);

		return mav;
	}
	
	@RequestMapping("/management_main.do")
	public ModelAndView management_form(HttpServletRequest request) {

		int mem_num = (int) request.getSession().getAttribute("mem_num");

//		int salary = dao.getSalary(mem_num);

		ModelAndView mav = new ModelAndView("salary_management_main");
//		mav.addObject("salary", salary);

		return mav;
	}

}
