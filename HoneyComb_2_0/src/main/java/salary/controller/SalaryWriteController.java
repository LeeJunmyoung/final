package salary.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import salary.db.SalaryDao;
import salary.db.SalaryDataBean;

@Controller
public class SalaryWriteController {

	private SalaryDao dao;

	@Autowired
	public void setDao(SalaryDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/management_writeForm.do")
	public ModelAndView write_form(@RequestParam(value = "mem_num") int mem_num) {

		SalaryDataBean salary = dao.getSalary(mem_num);

		ModelAndView mav = new ModelAndView("management_writeForm");
		mav.addObject("salary", salary);

		return mav;
	}

	@RequestMapping("/management_writePro.do")
	public ModelAndView write_pro(@RequestParam(value = "salary_num") int salary_num, HttpServletRequest request) {

		SalaryDataBean article = new SalaryDataBean();
		
		article.setSalary_num(salary_num);
		article.setSalary_year(Integer.parseInt(request.getParameter("salary_year")));
		article.setSalary_add_time(Integer.parseInt(request.getParameter("salary_add_time")));
		article.setSalary_add_holiday(Integer.parseInt(request.getParameter("salary_add_holiday")));
		article.setSalary_bonus(Integer.parseInt(request.getParameter("salary_bonus")));
		article.setCosts_food(Integer.parseInt(request.getParameter("costs_food")));
		article.setCosts_transport(Integer.parseInt(request.getParameter("costs_transport")));
		article.setCosts_benefit(Integer.parseInt(request.getParameter("costs_benefit")));
		article.setCosts_etc(Integer.parseInt(request.getParameter("costs_etc")));

		int salary_update_count =  dao.modSalary(article);
		
		ModelAndView mav = new ModelAndView("pro");
		mav.addObject("salary_update_count", salary_update_count);
		
		return mav;
	}

}
