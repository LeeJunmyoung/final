package dept_chart.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dept_chart.db.DeptDAO;


@Controller
@RequestMapping("/dept_memList")
public class Dept_MemList_Controller {
	
	private DeptDAO dao;
	
	
	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String dept_ListView() {
		
		
		return "dept_chart/dept_mem_list";
	}

	@ModelAttribute("dept_List")
	public List dept_ListSQL(@RequestParam("com_dept_num") int com_dept_num, HttpSession session) {
		
		int com_num = (int) session.getAttribute("com_num");
		List mem_List = new ArrayList<>();
		mem_List = dao.dept_List(com_num, com_dept_num);
		
		return mem_List;
	}

}
