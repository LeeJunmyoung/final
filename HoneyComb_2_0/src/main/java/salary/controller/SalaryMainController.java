package salary.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import salary.db.DeptDataBean;
import salary.db.PosDataBean;
import salary.db.SalaryDao;
import salary.db.SalaryDataBean;

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

		SalaryDataBean salary = dao.getSalary(mem_num);

		ModelAndView mav = new ModelAndView("salary_user_main");
		mav.addObject("salary", salary);

		return mav;
	}

	@RequestMapping("/management_main.do")
	public ModelAndView management_form(@RequestParam(value = "dept_num", defaultValue = "-1") int dept_num,
			@RequestParam(value = "pos_num", defaultValue = "-1") int pos_num, HttpServletRequest request) {

		int com_num = (int) request.getSession().getAttribute("com_num");

		List<DeptDataBean> dept = dao.getDeptList(com_num);
		List<PosDataBean> pos = dao.getPosList(com_num);

		List<SalaryDataBean> salaryList = dao.getSalaryList(com_num, dept_num, pos_num);

		ModelAndView mav = new ModelAndView("salary_management_main");

		mav.addObject("dept", dept);
		mav.addObject("pos", pos);
		mav.addObject("salaryList", salaryList);

		return mav;
	}

}
