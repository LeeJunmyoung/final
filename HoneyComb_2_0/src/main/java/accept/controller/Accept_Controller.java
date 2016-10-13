package accept.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import accept.db.AcceptDAO;

@Controller
public class Accept_Controller {

	private AcceptDAO dao;

	public void setDao(AcceptDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/accept")
	public String accept_MainView() {

		return "accept";

	}

	@ModelAttribute("awaiter_list")
	public List awaiter_list(HttpSession session) {

		int com_num = (int) session.getAttribute("com_num");
		List awaiter_list = new ArrayList<>();
		
		awaiter_list = dao.accept_List(com_num);

		return awaiter_list;
	}
	
	@ModelAttribute("count")
	public int all_Count(HttpSession session) {
		
		int com_num = (int) session.getAttribute("com_num");
		
		int count = dao.accept_count(com_num);
		
		return count;
	}
	
	@RequestMapping("/update_member")
	public String com_Up_Member(@RequestParam int mem_num, HttpSession session) {
		// member 승인
		
		int com_num = (int) session.getAttribute("com_num");
		
		dao.com_In_Member(mem_num, com_num);
		
		return "accept_close";
	}
	
	@RequestMapping("/delete_member")
	public String com_Del_Member(@RequestParam int mem_num) {
		// member 거절
		
		dao.com_Out_Member(mem_num);
		
		return "accept_close";
	}

}
