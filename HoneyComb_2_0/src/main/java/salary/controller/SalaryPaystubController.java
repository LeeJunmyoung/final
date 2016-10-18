package salary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import salary.db.SalaryDao;
import salary.db.SalaryDataBean;

@Controller
public class SalaryPaystubController {

	private SalaryDao dao;

	@Autowired
	public void setDao(SalaryDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/paystub.do")
	public ModelAndView paystubs_form(@RequestParam(value = "mem_num") int mem_num) {

		SalaryDataBean paystubs = dao.getSalary(mem_num);

		ModelAndView mav = new ModelAndView("paystub");
		mav.addObject("paystubs", paystubs);

		return mav;

	}

}