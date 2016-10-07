package dept.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dept.db.DeptDAO;

@Controller
public class Dept_MemResume_Controller {
	
	private DeptDAO dao;

	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/mem_resume")
	public String mem_Data() {
		
		return "dept_mem_resume";
	}
	
	@ModelAttribute("base_list")
	public List mem_Data_List(@RequestParam int mem_num) {
		
		List base_list = new ArrayList<>();
		base_list = dao.base_Data(mem_num);
		
		return base_list;
	}
	
	@ModelAttribute("school_list")
	public List mem_School_List(@RequestParam int mem_num) {
		
		List school_list = new ArrayList<>();
		school_list = dao.school_Data(mem_num);
		
		return school_list;
	}
	
	@ModelAttribute("certi_list")
	public List mem_Certi_List(@RequestParam int mem_num) {
		
		List certi_list = new ArrayList<>();
		certi_list = dao.certi_Data(mem_num);
		
		return certi_list;
	}
	
	@ModelAttribute("edu_list")
	public List mem_Edu_List(@RequestParam int mem_num) {
		
		List edu_list = new ArrayList<>();
		edu_list = dao.edu_Data(mem_num);
		
		return edu_list;
	}
	
	@ModelAttribute("mili_list")
	public List mem_Mili_List(@RequestParam int mem_num) {
		
		List mili_list = new ArrayList<>();
		mili_list = dao.mili_Data(mem_num);
		
		return mili_list;
	}
	
	@ModelAttribute("career_list")
	public List mem_Career_List(@RequestParam int mem_num) {
		
		List career_list = new ArrayList<>();
		career_list = dao.career_Data(mem_num);
		
		return career_list;
	}

}
