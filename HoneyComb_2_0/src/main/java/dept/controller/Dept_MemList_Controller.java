package dept.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dept.db.DeptDAO;

@Controller
public class Dept_MemList_Controller {

	private DeptDAO dao;

	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/dept_memList")
	public ModelAndView dept_ListSQL(@RequestParam("com_dept_num") int com_dept_num,
			@RequestParam("com_dept_name") String com_dept_name, HttpServletRequest request) {

		int com_num = (int) request.getSession().getAttribute("com_num");
		List dept_List = dao.dept_List(com_num, com_dept_num);
		
		ModelAndView mav = new ModelAndView("dept_mem");
		mav.addObject("dept_List", dept_List);
		mav.addObject("com_dept_name", com_dept_name);

		return mav;
	}

}
