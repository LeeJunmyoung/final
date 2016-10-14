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

		System.out.println(mem_num + " : " + salary.getName());

		ModelAndView mav = new ModelAndView("management_writeForm");
		mav.addObject("salary", salary);

		return mav;
	}

	@RequestMapping("/management_writePro.do")
	public ModelAndView write_pro(HttpServletRequest request) {

		int mem_num = (int) request.getSession().getAttribute("mem_num");

		SalaryDataBean salary = dao.getSalary(mem_num);

		ModelAndView mav = new ModelAndView("salary_write");
		mav.addObject("salary", salary);

		return mav;
	}

	/*
	 * @RequestMapping("/chkListAddPro.do") public ModelAndView
	 * submit(HttpServletRequest request) {
	 * 
	 * ChkListDataBean article = new ChkListDataBean();
	 * 
	 * article.setChklist_title_name(String.valueOf(request.getParameter(
	 * "promgr_list_title")));
	 * article.setPromgr_num(request.getParameter("promgr_num"));
	 * article.setCom_num((int) request.getSession().getAttribute("com_num"));
	 * 
	 * int promgr_insert_count = dao.addChkList(article);
	 * 
	 * ModelAndView mav = new ModelAndView("pro");
	 * mav.addObject("promgr_insert_count", promgr_insert_count);
	 * 
	 * return mav;
	 * 
	 * }
	 */

}
